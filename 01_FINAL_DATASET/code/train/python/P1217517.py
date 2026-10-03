N = int(input())
a = [[0] * N for i in range(26)]


for i in range(N):
	s = (input())
	for j in range(len(s)):
		ch = ord(s[j])
		#print(ch - ord("a"),i,j)
		a[ch - ord("a")][i] += 1

for i in range(26):
	M = min(a[i])
	for j in range(M):
		print(chr(i + ord("a")),end="")

print()