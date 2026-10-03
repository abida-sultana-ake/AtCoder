I=input
a=[]
n=int(I())-1
b=I();a+=[b]
for x in range(n):
    c=I()
    if b[-1]!=c[0] or c in a:print(['WIN','LOSE'][x&1]);exit()
    b=c;a+=[c]
print('DRAW')