N, M = map(int, input().split())

li = [0 for i in range(M+2)]
score = 0

for i in range(N):
    iseki = list(map(int, input().split()))
    a = iseki[0]
    b = iseki[1]
    li[a] += iseki[2]
    li[b+1] -= iseki[2]
    score += iseki[2]

for i in range(1, M+2):
    li[i] += li[i-1]

ans = score - min(li[1:-1])
print(ans)
