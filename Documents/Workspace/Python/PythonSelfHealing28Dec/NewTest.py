# from selenium import webdriver
#
# def inspect_element(driver, xpath):
#     try:
#         element = driver.find_element_by_xpath(xpath)
#
#         # Get tag name
#         tag_name = element.tag_name
#         print(f"Tag Name: {tag_name}")
#
#         # Get attributes
#         attributes = element.get_attribute('outerHTML')
#         print(f"Attributes: {attributes}")
#
#         # Get text content
#         text_content = element.text
#         print(f"Text Content: {text_content}")
#
#     except Exception as e:
#         print(f"Failed to inspect element. Error: {e}")
#
# # Example usage:
# driver = webdriver.Chrome()
# driver.get("https://www.google.com")
#
# # XPath of the element you want to inspect
# element_xpath = "//"
#
# # Call the inspect_element function
# inspect_element(driver, element_xpath)
#
# # Close the browser
# driver.quit()