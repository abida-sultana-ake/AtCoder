n,a=map(int,input().split())
k=int(input())
b=list(map(int,input().split()))
v=[None]*n
w=[0]*n
i,c=0,a
while v[c-1] is None:
    w[i]=c
    v[c-1] = i
    i+=1
    c=b[c-1]

head = v[c-1]
loop = i-v[c-1]
if k < head:
    print(w[k])
else:
    print(w[head + ((k-head)%loop)])
