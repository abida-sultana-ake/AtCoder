if __name__ == '__main__':

	N, M = map(int, input().split())
	n=[]
	for j in range(N):
		n.append(0)

	for i in range(M):
		a, b = map(int, input().split())
		n[a-1]+=1
		n[b-1]+=1

	for j in range(N):
		print(n[j])