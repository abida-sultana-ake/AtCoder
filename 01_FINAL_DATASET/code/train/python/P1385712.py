N = int(input())
A = list(map(int, input().split()))
A.sort()
ans = A[-1] - A[0]
print(ans)
