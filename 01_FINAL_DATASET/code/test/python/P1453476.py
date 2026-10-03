n = int(input())

t = list(map(int, input().split()))

m = int(input())

for i in range(m):
    ans = t
    p, x = map(int, input().split())
    tar = ans[p-1]
    ans[p-1] = x
    print(sum(ans))
    ans[p-1] = tar
