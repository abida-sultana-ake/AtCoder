N = int(input())

nurie = 110 / 900
#print(nurie)
result = []

for i in range(N):
    L = list(map(int, input().split()))
    ans = (sum(L)-L[4]) + (L[4] * nurie)
    result.append(ans)

print(max(result))
