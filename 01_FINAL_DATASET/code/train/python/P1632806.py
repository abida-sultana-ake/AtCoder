# coding: utf-8
# Here your code !

N  = int(input())
a = list(map(int,input().split()))
n_4 ,n_2 ,n_1 = 0,0,0
ans = ""

for i in range(N):
    if a[i] %4 ==0:
        n_4 += 1
    elif a[i] %4 == 2:
        n_2 += 1
    else :
        n_1 += 1
if n_1 < n_4 + 1:
    ans = "Yes"
elif (n_1 == n_4 + 1)and(n_2 == 0):
    ans = "Yes"
elif n_1 == 0:
    ans = "Yes"
else :
    ans ="No"

print(ans)