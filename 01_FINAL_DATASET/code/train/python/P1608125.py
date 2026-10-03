n = int(input())
A = input().split()
ans = [0] * n

for i in range(n):
    a = int(A[i])
    if a % 2 == 0:
        if a % 3 == 1:
            ans[i] = 1
        elif a % 3 == 2:
            ans[i] = 1
        else:
            ans[i] = 3
    else:
        if a % 3 == 2:
            ans[i] = 2

print(sum(ans))