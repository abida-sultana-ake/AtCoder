n=500501
p=[0]*2+[1]*(n-2)
for i in range(2,-~int(n**.5)):
    if p[i]:
        for j in range(i*i,n,i):
            p[j]=0
print(['BOWWOW','WANWAN'][p[sum(x+1 for x in range(int(input())))]])
