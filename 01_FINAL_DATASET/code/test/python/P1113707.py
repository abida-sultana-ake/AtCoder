I=input
a=[0]*6
for _ in [0]*int(I()):
    M,m=map(float,I().split())
    if M>=35:a[0]+=1
    elif M>=30:a[1]+=1
    elif M>=25:a[2]+=1
    if m<0 and 0<=M:a[4]+=1
    elif M<0:a[5]+=1
    if m>=25:a[3]+=1
print(*a)