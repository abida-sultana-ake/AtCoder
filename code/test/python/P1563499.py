n = int(input())
l = input().split()

for i in range(n):
	l[i] = int(l[i])
	
counting = 0
i = 0
#print(n)
while i < n-1:
	if l[i] == i+1:
		k = l[i]
		m = l[i+1]
		l[i] = m
		l[i+1] = k
		counting += 1
		#print(l)
	i += 1
#print(n)		
if l[n-1] == n:
	l[n-1] = l[n-2]
	l[n-2] = n
	counting += 1
#print(l)	
print(counting)