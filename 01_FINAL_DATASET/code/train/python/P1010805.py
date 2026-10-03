

N,x = list(map(int, input().split()))
a =  list(map(int, input().split()))


counter = 0


dif1 = a[N-2] + a[N-1] - x
if dif1 > 0:
        a1 = a[N-2] - dif1
        if a1 > 0:
            a[N-2] -= dif1
            counter  += dif1
        else:
            a[N-1]-= -a1
            a[N-2] = 0
            counter += dif1

for i in range(N-2):
    dif1 = a[i] + a[i+1] - x
    if dif1 > 0:
        a1 = a[i+1] - dif1
        if a1 > 0:
            a[i+1] -= dif1
            counter  += dif1
        else:
            a[i]-= -a1
            a[i+1] = 0
            counter += dif1

       
while a[N-2] + a[N-1] > x:
    if a[N-2] > 0:
        a[N-2] -= 1
    else :
        a[N-1] -= 1
    
    counter += 1

print(counter)