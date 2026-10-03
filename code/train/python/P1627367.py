N = input()
s = sum([int(i) for i in N])
l = int(N[-1])
if(N == "3" or N == "5" or N == "2"):
	print("Prime")
elif(l%2 and l%5 and s%3 and N != "1"):
	print("Prime")
else:
	print("Not Prime")