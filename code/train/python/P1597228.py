n = int(input())
k = int(input())
x = list(map(int,input().split()))
ans = 0
for i in x:
    if (k - i) <= i:
        ans += (k - i) * 2
    else:
        ans += (i * 2)
print(ans)