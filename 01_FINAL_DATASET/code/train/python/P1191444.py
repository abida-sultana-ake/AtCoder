line=input()
N=int(line.split(" ")[0])
M=int(line.split(" ")[1])
S=[]
T=[]
for var in range(0,M):
    line=input()
    S += [int(line.split(" ")[0])-1]
    T += [int(line.split(" ")[1])-1]

imos=[0 for n in range(0,N+1)]
ans=[]


for m in range(0,M):
    imos[S[m]]+=1
    imos[T[m]+1]-=1

imos2=[imos[0]]

for n in range(1,N):
    imos2+=[imos2[n - 1] + imos[n]]

imos3=[0]

for n in range(0,N):
    if(imos2[n]<2):
        imos3+=[imos3[n]+1]
    else:
        imos3+=[imos3[n]]

for m in range(0,M):
    if(imos3[T[m]+1]-imos3[S[m]]==0):
        ans+=[m]

print(len(ans))
for var in range(0,len(ans)):
    print(ans[var]+1)
