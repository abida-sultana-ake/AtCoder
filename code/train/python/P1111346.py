c=''
p=''
for x in input():
    if x==p:c+=1
    else:print(p+str(c),end='');c=1
    p=x
print(x+str(c))