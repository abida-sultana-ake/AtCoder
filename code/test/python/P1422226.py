n = int(input())
xs = list(map(int, input().split()))

s = sum(xs)

cumsum = 0

ans = 10000000000000000000000

for x in xs[:-1]:
    cumsum += x
    ans = min(ans, abs(s-cumsum*2))

print(ans)