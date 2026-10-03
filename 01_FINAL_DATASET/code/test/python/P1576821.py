N = int(input())
cnt = 0

for _ in range(N):
    l, r = map(int, input().split())
    cnt += r-l+1

print(cnt)