S = input()

i = 0
while(i < len(S)):
	j = i+1
	while(j < len(S)):
		if(S[i] == S[j]):
			print("no")
			exit(0)
		j += 1
	i += 1
print("yes")
