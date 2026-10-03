n = int(input())
t = list(map(int, input().split()))
m = int(input())
while(m):
	p, x = map(int, input().split())
	print(sum(t)-t[p-1]+x)
	m -= 1