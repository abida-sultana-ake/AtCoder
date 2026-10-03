N = int(input())
ans = 101

for i in range(N):
    t = int(input())
    if ans > t:
        ans = t

print(ans)