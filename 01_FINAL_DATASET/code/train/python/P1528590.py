n = int(input())
s1 = input()
s2 = input()
l = []
m = 1
mod = 10**9 + 7

after = False
for i in range(n):
	if i == n-1:
		if after:
			pass
		else:
			l.append(0)
	else:
		if after:
			after = False
			pass
		else:
			if s1[i] == s1[i+1]:
				l.append(1)
				after = True
			else:
				l.append(0)

for i, x in enumerate(l):
	if i == 0:
		if x == 0:
			m = 3
		else:
			m = 6 
	else:
		if x == 0 and l[i-1] == 0:
			m = m * 2
			m = m % mod
		elif x == 1 and l[i-1] == 0:
			m = m * 2
			m = m % mod
		elif x == 0 and l[i-1] == 1:
			pass
		else:
			m = m * 3
			m = m % mod

print(m)