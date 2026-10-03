#coding: UTF-8
import math
N=int(input())
def prime_list(k):
    lis=[True for i in range(1,k+1)]
    lis[0]=False
    for i in range(2,k+1):
        j=2
        while j*j<=i:
            if i%j==0:
                lis[i-1]=False
                break
            else:
                j+=1
    return lis
#    print(lis)
def p_fact(k,N):
    plist=prime_list(k)
    lis=[0]*N
    for i in range(0,k):
        n=0
        if plist[i]:
            while k%(i+1)==0:
                n+=1
                k=k/(i+1)
        lis[i]=n
    return lis
out_lis=[0]*N
for i in range(1,N+1):
    input_lis=p_fact(i,N)
    out_lis=[out_lis[j]+input_lis[j] for j in range(0,N)]
#print(out_lis)
out=1
for i in range(0,N):
    out=out*(out_lis[i]+1)
print(out%1000000007)