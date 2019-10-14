import requests
import re
import numpy as np
import json
from bs4 import BeautifulSoup

url = 'https://sis.rpi.edu/reg/zs201909.htm'
res = requests.get(url)

html = res.text

mysoup = BeautifulSoup(html, 'lxml')
course_list = mysoup.find_all('td')
cn = []
ccrnn = []
ctitle = []
for c in course_list:
	reg1 = re.compile(r"top: \d+.\dpt; left: 136.8pt; margin-top:0pt;")
	reg2 = re.compile(r"top: \d+.\dpt; left: 0.0pt; margin-top:0pt;")
	r1 = c.find('span', attrs={'class':'f0', 'style':reg1})
	r2 = c.find('span', attrs={'class':'f0', 'style':reg2})
	if r1:
		r11 = r1.getText()
		cn.append(r11)
	if r2:
		r22 = r2.getText()
		(c, t) = r22.split(' ')
		tt = t[:-3]
		ccrnn.append(c)
		ctitle.append(tt)
ctitle_set = list(set(ctitle))
ctitle_set.sort(key=ctitle.index)
names = np.array(cn)
crn = np.array(ccrnn)
title = np.array(ctitle_set)


# url = 'https://sis.rpi.edu/reg/zs201909.htm'
# response = urllib.request.urlopen(url)
# # print (response.getcode())
# data = response.read()
# data = data.decode('utf-8')
# print ()

# def login(self, response):
# 	post_url = "https://sis.rpi.edu/rss/twbkwbis.P_WWWLogin"
# 	post_data = {"user_id" : "660286461", "pin" : }
# 	return [scrapy.FormRequest(
# 		url = post_url,
# 		formdata = post_data,
# 		headers = self.headers,
# 		callback = self.check_login
# 		)]

# def check_login(self, response):
# 	json_text = json.loads(response.text)
# 	if "msg" in json_text and json_text["msg"] == "successful login":
# 		for url in self.start_urls:
# 			yield scrapy.Request(url, dont_filter = True, headers = self.headser)

# # Request URL = "https://sis.rpi.edu/css/web_defaultapp.css"



# link = "https://sis.rpi.edu/rss/twbkwbis.P_WWWLogin"
# r = urllib.request.Reqeust(link)
# ug = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763'
# r.add_header('User-Agent', ug)
# cookie = "BIGipServersis.rpi.edu.app~sis.rpi.edu_pool=1619030400.47873.0000; path=/; Httponly; Secure"
# r.add_header('Cookie', cookie)



# headers = {
# 			'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763', 
# 			'Cookie': 'BIGipServersis.rpi.edu.app~sis.rpi.edu_pool=1619030400.47873.0000; path=/; Httponly; Secure'}
# session = requests.Session()
# response = session.get('https://sis.rpi.edu/rss/twbkwbis.P_GenMenu?name=bmenu.P_MainMnu&msg=WELCOME+%3Cb%3EWelcome,+Yi+Zhou,+to+the+Rensselaer+Self-Service+Information+System!%3C%2Fb%3ESep+27,+201903%3A35+pm')
# print (response.text)