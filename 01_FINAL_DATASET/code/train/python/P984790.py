N, K = map(int, input().split())
S = input().split()
		
flag = False

for i in range(N, 10*N):
	for k in range(len(str(i))):
		if str(i)[k] in S:
			flag = False
			break
		else:
			flag = True
			continue
		
	if flag:
		print(i)
		break