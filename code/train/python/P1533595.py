N, K = list(map(int, input().split(" ")))
A = sorted(list(map(int, input().split(" "))), reverse=True)

result = 0
S = sum(A)
n = len(A)
s = 0
if S<K:
    result = n
elif S == K:
    result = 0
else:
    for i in range(n):
        if s+A[i] >= K:
            result = n - i - 1
        else:
            s += A[i]

print(result)
