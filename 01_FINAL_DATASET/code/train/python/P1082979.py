input_str=input()
# input_str="QWERTYASDFZXCV"
# input_str="ZABCZ"
# input_str="HASFJGHOGAKZZFEGA"
b=0
e=0
length=len(input_str)
for i, s in enumerate(input_str):
	if s=="A":
		b=i
		# print(b)
		break
for i, s in enumerate(input_str[::-1]):
	if s=="Z":
		e=length-i
		# print(e)
		break
print(e-b)
