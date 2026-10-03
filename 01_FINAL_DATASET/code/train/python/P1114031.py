I=input
I()
a=I().split();b=0
for x in I().split():
    if x in a:b+=1;a.remove(x)
    if not a:break
print(b)