import math
N = int(input())

A = list(map(int,input().split()))

A_s = sorted(A)

flag = True

if N%2 ==0:
    for i in range(N//2):
        if A_s[i*2] != 2*i+1 or A_s[i*2+1] != 2*i+1:
            flag = False
            break
else:
    for i in range(N//2+1):
        if i==0:
            if A_s[i] !=0:
                flag = False
                break
        else:
            if A_s[2*i-1] !=2*i or A_s[2*i] != 2*i:
                flag = False
                break

const = 10**9+7
base =2
po_sum = N//2
ans =1
if flag:
    while 1:
        po = math.log(const,base)
        # print(const,base,po)
        po = int(po)+1
        po_a = po_sum % (po)
        po_sum = po_sum // (po)
        # print(po_a,po_sum)
        ans *= base**po_a
        base = base**po % const
        # print(base)
        ans = ans % const
        if po_sum ==0:
            break
    print(ans)



else:
    print(0)
