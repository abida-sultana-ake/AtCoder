import sys
N, M = list(map(int, input().split()))
name = input()
kit = input()
AtoZ = [chr(ord('A')+i) for i in range(26)]
d1 = [name.count(c) for c in AtoZ]
d2 = [kit.count(c) for c in AtoZ]
for i in range(26):
    if d1[i] > 0 and d2[i] == 0:
        print(-1)
        sys.exit()

d3 = [d1[i] // d2[i] if d1[i] % d2[i] == 0 else d1[i]//d2[i] + 1 for i in range(26) if d1[i] > 0]
print(max(d3))