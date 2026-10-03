x=int(input())

if (x%11)>6:
    a=2
elif (x%11)==0:
    a=0
else:
    a=1

print(int(x/11)*2+a)