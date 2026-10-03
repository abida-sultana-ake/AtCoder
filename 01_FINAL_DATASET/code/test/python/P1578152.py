N = int(input())
ans = 0
for i in range(N):
    l,r = input().split()
    ans += int(r)-int(l)+1
print(ans)