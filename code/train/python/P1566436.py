N = 10**5 + 10
n = int(input())
a = list(map(int, input().split()))
c = [0] * N
for i in a: c[i] += 1
ans = max(c[i - 1] + c[i] + c[i + 1] for i in range(1, N - 1))
print(ans)
    