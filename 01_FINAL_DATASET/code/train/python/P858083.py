from functools import reduce

n = int(input())
a = list(map(int,input().split()))

end = max(a)
ansAry = []

b = min(a)
while(True):
    suma = []
    for i in range(0,len(a)):
        if b == a[i]:
            pass
        else:
            suma.append((a[i] - b)*(a[i] - b))

    try:
        ansAry.append(reduce(lambda x,y:x+y,suma))
    except:pass

    if b == end:
        break
    b += 1

if len(ansAry) > 0:
    print(min(ansAry))
else:
    print(0)