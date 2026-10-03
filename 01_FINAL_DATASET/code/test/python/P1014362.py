from collections import Counter
S = [l for l in input()]
c = Counter(S)
k = 0
t = 0
for l in c:
	t += c[l]//2
	k += c[l]%2
if k == 0:
	print(len(S))
else:
	print(t//k*2+1)
