E=set(input().split())
B=input()
L=set(input().split())

l=len(L-E)
if l==0:r=1
elif l==1:
    if B in L:r=2
    else:r=3
elif l<4: r=2+l
else:r=0
    
print(r)