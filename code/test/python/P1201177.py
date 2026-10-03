import sys

n,k = map(int,input().split(' '))
s = [int(input()) for _ in range(n)]

if 0 in s:
    print(n)
    sys.exit()

result = 0
i,j = 0,0
product = 1
while True:
    if product*s[j] <= k:
        product *= s[j]
        j += 1
    elif i == j:
        i += 1
        j += 1
    else:
        product //= s[i]
        i += 1
    result = max(result,j-i)
    if j == n:
        break
print(result)