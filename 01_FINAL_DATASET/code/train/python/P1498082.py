n=int(input())
arr=list(map(int,input().split()))
a4=0
a2=0
a1=0
for a in arr:
    if a%4==0:
        a4+=1
    elif a%2==0:
        a2+=1
    else:
        a1+=1
if a1==0:
    print("Yes")
elif a2==0:
    if a1<=a4+1:
        print("Yes")
    else:
        print("No")
else:
    if a1<=a4:
        print("Yes")
    else:
        print("No")
