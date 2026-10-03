N, S, T = map(int, input().split())
W = int(input())
ret = S <= W <= T
for _ in range(N-1):
    W += int(input())
    ret += S <= W <= T
print(ret)
