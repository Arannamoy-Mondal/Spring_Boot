from selenium.webdriver import Chrome,Firefox,Edge
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
import time
# service=Service("driver location")
# chrome_driver=Chrome(service=service)
chrome_driver=Chrome()
chrome_driver.get("https://github.com/Arannamoy-Mondal")
chrome_driver.maximize_window()
print(chrome_driver.title)
print(chrome_driver.current_url)

chrome_driver.find_element(By.NAME,"email").send_keys("email@email.com")
chrome_driver.find_element(By.ID,"password").send_keys("password")
chrome_driver.find_element(By.ID,"agree terms and conditions").click()
chrome_driver.find_element(By.CSS_SELECTOR,"//input[@type='sumbmit']").click() # can use selectorhub extension for this
chrome_driver.find_element(By.CSS_SELECTOR,"input[name='name']").send_keys("hello")
chrome_driver.find_element(By.LINK_TEXT,"Forget Password").click()
txt1=chrome_driver.find_element(By.CLASS_NAME,"alert").text
print(txt1)

static_dropdown=Select(chrome_driver.find_element(By.ID,"id"))
static_dropdown.select_by_visible_text("Male")
static_dropdown.select_by_index(0)
static_dropdown.select_by_value(0)
time.sleep(10)

assert "Success" in txt1