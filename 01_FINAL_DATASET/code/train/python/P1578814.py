

N=int(input())
a=[]
for i in range(N):
    a.append(int(input()))

chk={}

for sa in a:
    if sa in chk:
        if chk[sa]==1:
            chk[sa]=0
        else:
            chk[sa]=1
    else:
        chk[sa]=1


print(sum(chk.values()))
