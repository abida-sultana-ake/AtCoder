# coding: utf-8
# Here your code !
 
n = int(input())
ng = sorted([int(input()) for i in range(3)],reverse=True)
if n in ng:
    print("NO")
elif ng[0]-1==ng[1] and ng[1]-1==ng[2] and n>ng[0]:
    print("NO")
else:
    movelist=[3,2,1]
    for _ in range(100):
        for i in movelist:
            if n-i not in ng:
                #print(n)
                n=n-i
                break
    if n<=0:
        print("YES")
    else:
        print("NO")