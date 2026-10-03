A = int(input())
B = A*A
C = (A+1)*(A+1)
ans = B
flag = False
flag2 = False
while True:
    if B % 100 != 0:
        flag = True
    if C % 100 != 0:
        flag2 = True

    B //= 100
    C //= 100
    if B == 0:
        break
    if flag == False:
        ans = B
    elif (flag2 and B < C ) or B+2 <= C:
        ans = B + 1
print(ans)