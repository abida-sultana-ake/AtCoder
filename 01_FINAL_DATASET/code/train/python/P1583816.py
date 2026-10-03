N = int(input())
p = [int(x)-1 for x in input().split()]

ans = 0
i = 0

while i<N:
    if p[i]==i:
        i += 1
        ans += 1
    i += 1

print(ans)