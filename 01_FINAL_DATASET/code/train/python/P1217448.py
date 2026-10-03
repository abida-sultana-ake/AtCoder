INF = 10**8
N = int(input())
S = [input() for _ in range(N)]
k = [INF] * 26

for s in S:
    for i in range(26):
        k[i] = min(k[i], s.count(chr(ord('a') + i)))

ret = ""
for i in range(26):
    ret += chr(ord('a') + i) * k[i]
print(ret)