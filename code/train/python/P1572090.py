N, S, T = map(int, input().split())
cnt = 0
for i in range(N):
    if i == 0:
        W = int(input())
    else:
        W += int(input())
    if S <= W <= T:
        cnt += 1
print(cnt) 