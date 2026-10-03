n, k = map(int, input().split())
li = list(map(int, input().split()))
li.sort()
ansli = li[n-k:]

ans = 0
for i in range(len(ansli)):
    ans += ansli[i]
    ans /= 2
print(ans)
