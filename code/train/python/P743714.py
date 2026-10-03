n = int(input())
a = [int(i) for i in input().split(" ")]

p = -1
c = 0
ans = 0
for k in a:
    if p < k:
        c += 1
        p = k
    else:
        ans += (c+1)*c//2
        p = k
        c = 1

if c != 0:
    ans += (c+1)*c//2

print(ans)
