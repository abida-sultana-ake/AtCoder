a=input()
y=0
for c in a:
    if c=='3':
        y=1
if int(a)%3==0:
    y=1
if y==1:
    print('YES')
else :
    print('NO')