from selenium import webdriver
from selenium.webdriver.firefox.options import Options
from time import sleep
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from bs4 import BeautifulSoup

url = 'https://sis.rpi.edu/rss/twbkwbis.P_WWWLogin'

# options = webdriver.FirefoxOptions()
# options.add_argument('-headless')
# driver = webdriver.Firefox(firefox_options=options)
options = Options()
options.headless = True
browser = webdriver.Firefox(options=options)
browser.get(url)
user = browser.find_element_by_id("UserID")
user.send_keys("660286461")
sleep(10)
pw = browser.find_element_by_name("PIN")
pw.send_keys("Kk1317111317")
sleep(10)
pw.send_keys(Keys.RETURN)
sleep(10)
browser.find_element_by_css_selector("input[type='submit']").click()
browser.get("https://sis.rpi.edu/rss/twbkwbis.P_GenMenu?name=bmenu.P_MainMnu&msg=WELCOME+%3Cb%3EWelcome,+Yi+Zhou,+to+the+Rensselaer+Self-Service+Information+System!%3C%2Fb%3ENov+10,+201908%3A18+pm")
browser.find_element_by_link_text("Student Menu").click()
browser.find_element_by_link_text("Class Search").click()
# browser.find_element_by_id("term_input_id").find_element_by_xpath("//option[@value='201909']").click()

# terms = browser.find_element_by_name("p_term")

# for term in terms.find_elements_by_tag_name("option"):
# 	if term.text == 'Fall 2019':
# 		term.click()
# 		print (browser.page_source)
# 		break

# terms = Select(browser.find_element_by_xpath("//select[@id='term_input_id']"))
# term = terms.select_by_value("201909").click()
# for term in terms.find_elements_by_tag_name("option"):
# 	if "Fall 2019" in term.text:
# 		term.click()
# 		sleep(10)
# 		break

s = Select(browser.find_element_by_id("term_input_id"))
s.select_by_value("201909")
sleep(10)
# browser.find_element_by_id("term_input_id").find_element_by_xpath("//option[@value='201909']").click()
browser.find_element_by_css_selector("input[type='submit']").click()
sleep(10)
browser.quit()



# import requests
# import re
# import numpy as np
# import json
# from bs4 import BeautifulSoup

# url = 'https://sis.rpi.edu/reg/zs201909.htm'
# res = requests.get(url)

# html = res.text

# mysoup = BeautifulSoup(html, 'lxml')
# course_list = mysoup.find_all('td')
# cn = []
# ccrnn = []
# ctitle = []
# for c in course_list:
# 	reg1 = re.compile(r"top: \d+.\dpt; left: 136.8pt; margin-top:0pt;")
# 	reg2 = re.compile(r"top: \d+.\dpt; left: 0.0pt; margin-top:0pt;")
# 	r1 = c.find('span', attrs={'class':'f0', 'style':reg1})
# 	r2 = c.find('span', attrs={'class':'f0', 'style':reg2})
# 	if r1:
# 		r11 = r1.getText()
# 		cn.append(r11)
# 	if r2:
# 		r22 = r2.getText()
# 		(c, t) = r22.split(' ')
# 		tt = t[:-3]
# 		ccrnn.append(c)
# 		ctitle.append(tt)
# ctitle_set = list(set(ctitle))
# ctitle_set.sort(key=ctitle.index)
# ctitle_list = list(ctitle_set)
# names = np.array(cn)
# crn = np.array(ccrnn)
# title = np.array(ctitle_set)

# file1 = 'course_title.json'
# with open(file1, 'w') as file_object:
# 	json.dump(ctitle_list, file_object)
# file2 = 'course_name.json'
# with open(file2, 'w') as file_object:
# 	json.dump(cn, file_object)
# file3 = 'course_crn.json'
# with open(file3, 'w') as file_object:
# 	json.dump(ccrnn, file_object)


# # url = 'https://sis.rpi.edu/reg/zs201909.htm'
# # response = urllib.request.urlopen(url)
# # # print (response.getcode())
# # data = response.read()
# # data = data.decode('utf-8')
# # print ()

# # def login(self, response):
# # 	post_url = "https://sis.rpi.edu/rss/twbkwbis.P_WWWLogin"
# # 	post_data = {"user_id" : "660286461", "pin" : }
# # 	return [scrapy.FormRequest(
# # 		url = post_url,
# # 		formdata = post_data,
# # 		headers = self.headers,
# # 		callback = self.check_login
# # 		)]

# # def check_login(self, response):
# # 	json_text = json.loads(response.text)
# # 	if "msg" in json_text and json_text["msg"] == "successful login":
# # 		for url in self.start_urls:
# # 			yield scrapy.Request(url, dont_filter = True, headers = self.headser)

# # # Request URL = "https://sis.rpi.edu/css/web_defaultapp.css"



# # link = "https://sis.rpi.edu/rss/twbkwbis.P_WWWLogin"
# # r = urllib.request.Reqeust(link)
# # ug = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763'
# # r.add_header('User-Agent', ug)
# # cookie = "BIGipServersis.rpi.edu.app~sis.rpi.edu_pool=1619030400.47873.0000; path=/; Httponly; Secure"
# # r.add_header('Cookie', cookie)



# # headers = {
# # 			'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763', 
# # 			'Cookie': 'BIGipServersis.rpi.edu.app~sis.rpi.edu_pool=1619030400.47873.0000; path=/; Httponly; Secure'}
# # session = requests.Session()
# # response = session.get('https://sis.rpi.edu/rss/twbkwbis.P_GenMenu?name=bmenu.P_MainMnu&msg=WELCOME+%3Cb%3EWelcome,+Yi+Zhou,+to+the+Rensselaer+Self-Service+Information+System!%3C%2Fb%3ESep+27,+201903%3A35+pm')
# # print (response.text)