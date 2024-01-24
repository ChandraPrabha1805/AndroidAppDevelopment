from selenium import webdriver
import xml.etree.ElementTree as ET

class SelfHealingLocator:
    def __init__(self, driver, initial_dom_path, current_dom_path, report_path):
        self.driver = driver
        self.initial_dom_path = initial_dom_path
        self.current_dom_path = current_dom_path
        self.report_path = report_path

    def save_dom_as_xml(self, output_file):
        try:
            root_element = self.driver.find_element_by_xpath('/html')
            dom_xml_string = ET.tostring(root_element, encoding='unicode')
            with open(output_file, 'w', encoding='utf-8') as file:
                file.write(dom_xml_string)
            print(f"DOM saved successfully to {output_file}")
        except Exception as e:
            print(f"Error saving DOM: {e}")

    def compare_and_heal(self):
        initial_dom_tree = ET.parse(self.initial_dom_path)
        current_dom_tree = ET.parse(self.current_dom_path)

        initial_dom_elements = set(initial_dom_tree.iter())
        current_dom_elements = set(current_dom_tree.iter())

        missing_elements = initial_dom_elements - current_dom_elements

        if missing_elements:
            print("Missing locators found. Healing...")

            for element in missing_elements:
                xpath = self.get_xpath(element)
                healed_element = self.find_element_by_xpath(xpath)

                if healed_element:
                    self.save_dom_as_xml(self.current_dom_path)
                    self.generate_report(xpath)

            print("Healing complete.")
        else:
            print("No missing locators found.")

    def find_element_by_xpath(self, xpath):
        try:
            return self.driver.find_element_by_xpath(xpath)
        except Exception as e:
            print(f"Error finding element by XPath: {e}")
            return None

    def get_xpath(self, element):
        path = [element.tag]
        while element.getparent() is not None:
            path.insert(0, element.getparent().tag)
            element = element.getparent()
        return '/' + '/'.join(path)

    def generate_report(self, xpath):
        with open(self.report_path, 'a', encoding='utf-8') as report_file:
            report_file.write(f"Missing locator: {xpath}\n")

# Example usage:
initial_dom_path = "initial_dom.xml"
current_dom_path = "current_dom.xml"
report_path = "missing_locators_report.txt"

driver = webdriver.Chrome()
driver.get("https://www.google.com")

# Create a SelfHealingLocator instance
locator = SelfHealingLocator(driver, initial_dom_path, current_dom_path, report_path)

# Save the initial DOM
locator.save_dom_as_xml(initial_dom_path)

# Save the current DOM
locator.save_dom_as_xml(current_dom_path)

# Compare and heal the locators
locator.compare_and_heal()

# Close the browser
driver.quit()
