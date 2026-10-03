S = input().split()
tf7 = False
tf52 = False
count5 = 0
for x in S:
	if x == "5":
		count5 += 1
		if count5 == 2:
			tf52 = True
	if x == "7":
		tf7 = True
if tf7==True and tf52==True:
	print("YES")
else :
	print("NO")


