n, t = [int(t) for t in input().split()]
now = int(input())
cnt = 0

for i in range(1, n):
    a = int(input())
    cnt += t if a-now>=t else (a-now)
    now = a

cnt += t

print(cnt)

