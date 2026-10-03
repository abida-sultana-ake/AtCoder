t = int(input())
n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))

j = 0
result = True
if n < m:
    print("no")
    exit(0)

for i in range(n):
    if a[i] + t >= b[j] >= a[i]:
        j = j+1
        if j == m:
            break
    elif i == n-1:
        result = False

if result:
    print("yes")
else:
    print("no")
