S = input()
s = S[0]
e = S[-1]
if s == e:
	if len(S) % 2:
		print("Second")
	else:
		print("First")
else:
	if len(S) % 2:
		print("First")
	else:
		print("Second")