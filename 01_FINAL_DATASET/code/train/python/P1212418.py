n = int(input())
s = []
for i in range(n):
    s.append(input())

ans = ""

INF = 1000

for c_i in range(ord('a'), ord('z')+1):
    small = INF
    c = chr(c_i)
    for i in range(n):
        cnt = s[i].count(c)
        small = min(small, cnt)
    ans += c * small

print(ans)