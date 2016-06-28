import json
from pprint import pprint

json_data = open('MAHABHARATA.JSON').read()
data = json.loads(json_data)
for i in data:
	answers = i["Answers"]
	position = i["Correct Answer"]
	qstr = "Question #" + i["Q #"] + ")"
	print (qstr, i["Q"])
	print ("Choices: ")
	count = 0
	for j in answers:
		print (count,' : ',j)
		count+=1

	print ("Correct Answer:", answers[position])
	print("\n")