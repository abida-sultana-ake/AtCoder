MAX_N = 10 ** 5 + 10
N = int(input())
A = list(map(int, input().split()))
result = 0
pre = A[0]
cnt = 1
for i in range(1, len(A)):
    if (A[i] > pre):
        cnt += 1
    else:
        result += cnt * (cnt + 1) // 2
        cnt = 1
    pre = A[i]
result += cnt * (cnt + 1) // 2
print (result)
    
