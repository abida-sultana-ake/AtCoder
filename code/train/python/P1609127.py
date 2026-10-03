A, B = list(map(str, input().split()))
fac = 100
ans = 0
for i in range(3):
    x = 9 - int(A[i])
    if i == 0:
        y = int(B[i]) - 1
    else:
        y = int(B[i]) - 0
    z = max(x, y)
    if z != 0:
        ans = fac * z
        break
    fac //= 10
print(int(A)-int(B)+ans)