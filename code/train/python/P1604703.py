
N, S, T = map(int, input().split())

W = int(input())

res = 0;

if S <= W <= T:
    res += 1

for _ in range(N - 1):
    W += int(input())
    if S <= W <= T:
        res += 1

print(res)
