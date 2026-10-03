n=int(input())
hana=[int(i) for i in input().split()]
count=0

for i in range(n):
   if hana[i]%6!=1 and hana[i]%6!=3:
         count=count+abs(hana[i]%6-3)

print(count)