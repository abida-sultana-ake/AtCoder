n = int(input())
S = [input() for _ in range(n)]

def bag_of_char(s):
	boc = {}
	sl = list(s)
	for c in sl:
		boc[c] = boc[c] + 1 if c in boc else 1
	return boc

boc = bag_of_char(S[0])

for s in S:
	for k in boc.keys():
		boc_s = bag_of_char(s)
		if k in boc_s:
			boc[k] = min(boc[k], boc_s[k])
		else:
			boc[k] = 0

res = ""
for k,v in boc.items():
	res = res + k * v

res = sorted(list(res))
print("".join(res))
