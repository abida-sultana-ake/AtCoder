n = int(input())
imos = [0 for i in range(1000002)]
for i in range(n):
    a, b = map(int, input().split())
    imos[a] += 1
    imos[b + 1] -= 1
ans = []
j = 0
for i in imos:
    ans.append(j + i)
    j += i
print(max(ans))
