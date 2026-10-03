from sys import stdin, stdout, stderr

N, K = map(int, input().split())
s = [int(stdin.readline()) for i in range(N)]

if 0 in s:
    print(N)
    exit()

if K == 0:
    print(0)
    exit()

s.append(K + 1)
ans, v = 0, 1
r = 0

for l in range(N):
    for r in range(r, N + 1):
        if v > K:
            break
        else:
            ans = max(ans, r - l)
            v *= s[r]

    v //= s[l]

print(ans)