import sys
f = sys.stdout.write
n,l=map(int,input().split())
s = [];
for _ in range(n):
	s.append(input())
s.sort()
for i in range(n):
	f(s[i])