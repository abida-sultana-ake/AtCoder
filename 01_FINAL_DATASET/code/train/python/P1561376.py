N = int(input())
a = list(map(int, input().split()))

num = [0 for i in range(100000)]
for aa in a:
    num[aa] += 1

ans = 0
for X in range(1, 99999):
    ans = max(ans, sum(num[X-1:X+2]))

print(ans)
