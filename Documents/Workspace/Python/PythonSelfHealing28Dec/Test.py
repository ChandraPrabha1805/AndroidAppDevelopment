#
# from selenium import webdriver
# from selenium.webdriver.common.by import By
# from selenium.webdriver.support.ui import WebDriverWait
# from selenium.webdriver.support import expected_conditions as EC
#
# class SelfHealingLocator:
#     def __init__(self, driver):
#         self.driver = driver
#         self.previous_dom = None
#
#     def get_element(self, by, value, timeout=10):
#         try:
#             element = WebDriverWait(self.driver, timeout).until(
#                 EC.presence_of_element_located((by, value))
#             )
#             return element
#         except Exception as e:
#             print(f"Element not found using {by}={value}")
#             self.heal_locator(by, value)
#             return None
#
#     def get_current_dom(self):
#         return self.driver.page_source
#
#     def heal_locator(self, by, value):
#         current_dom = self.get_current_dom()
#
#         if self.previous_dom != current_dom:
#             print("DOM has changed. Attempting to heal the locator...")
#
#             # You may implement a logic to find the element based on the changed DOM.
#             # For simplicity, let's try using the previous locator type and value.
#             new_element = self.get_element(by, value)
#
#             if new_element:
#                 print("Locator healed successfully.")
#             else:
#                 print("Unable to heal the locator.")
#
#         # Update the previous DOM
#         self.previous_dom = current_dom
#
# # Example usage:
# driver = webdriver.Chrome()
# driver.get("https://www.google.com")
#
# locator_manager = SelfHealingLocator(driver)
#
# # Example: Finding an element using the self-healing locator
# element = locator_manager.get_element(By.XPATH, "//a[text()='About']")
#
# # Perform actions with the found element (e.g., click)
# if element:
#     element.click()
#
# # Close the browser
# driver.quit()
# ***/