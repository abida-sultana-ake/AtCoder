N = int(input())
N_ = N-1
a = list(map(int, input().split()))
result = 0

while max(a) >= N:
    for i in range(N):
        if a[i] >= N:
            mul, a[i] = divmod(a[i], N)
            for j in range(N):
                if i == j:
                    continue
                a[j] += mul
            result += mul

print(result)