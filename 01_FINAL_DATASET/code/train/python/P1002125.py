N = int(input())
a = []
for i in range(N):
	a.append(int(input()))
sa = sorted(set(a))

dic = {sa[i]: i for i in range(len(sa))}

for j in range(N):
	print(dic[a[j]])