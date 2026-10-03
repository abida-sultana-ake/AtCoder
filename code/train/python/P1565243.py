t = int(input())
n = int(input())
A = [int(i)for i in input().split()]
m = int(input())
B = [int(i)for i in input().split()]
c,i,ans = 0,0,0
while i < m and c < n:
    if A[c] <= B[i] <= A[c]+t:
        ans += 1
        i += 1
        c += 1
    else:
        c += 1
if ans == len(B):
    print('yes')
else:
    print('no')