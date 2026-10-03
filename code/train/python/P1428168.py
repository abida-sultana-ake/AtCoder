a=input().split()
A=int(a[0])
B=int(a[1])
C=A+B
if((A%3==0)or(B%3==0)or(C%3==0)):
 print("Possible")
else:
 print("Impossible")