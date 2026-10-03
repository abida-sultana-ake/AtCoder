N = int(input())
imos = [0 for i in range(10000001)]

for i in range(N):
    nums = [int(x) for x in input().split()]
    a,b = nums[0],nums[1]
    imos[a] += 1
    imos[b+1] -= 1

ans = []
j = 0
for i in imos:
    ans.append(j+i)
    j += i

print(max(ans))