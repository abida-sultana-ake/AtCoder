n=input()
for l in range(n):
	locals()["m_%d" % l]="a"
for i in range(n):
	str=raw_input()
	for j in range(n):
		locals()["m_%d" % j]=str[j]+locals()["m_%d" % j]
for k in range(n):
	print(locals()["m_%d" % k].rstrip("a"))