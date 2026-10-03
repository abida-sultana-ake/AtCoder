import itertools

l = list(map(int, input().split()))

com = itertools.combinations(l, 3)
ans = list(map(sum, com))
ans.sort(reverse=True)

print(ans[2])
