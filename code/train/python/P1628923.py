X=int(input())
ans=X//11*2
if (X%11==0):
 print(ans)
elif (X%11<=6):
 print(ans+1)
else:
 print(ans+2)
