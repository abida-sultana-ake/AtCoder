#coding=UTF-8

mozir=input()
hyo=mozir.split(' ')
N=int(hyo[0])
W=int(hyo[1])

weight=[]
values=[]
for idx in range(0,N,1):
    mozir=input()
    hyo=mozir.split(' ')
    weight.append(int(hyo[0]))
    values.append(int(hyo[1]))

minimum_weight=min(weight)
weight_values=list(range(0,4,1))
for idx in range(0,4,1):
    weight_values[idx]=[]

for idx in range(0,N,1):
    weight_values[weight[idx]-minimum_weight].append(values[idx])

for idx in range(0,4,1):
    weight_values[idx].sort(reverse=True)

#print(weight_values)

jogen=min(W//minimum_weight,len(weight_values[0]))

tmpten=[0,0,0]
tmpomo=[0,0,0]
ans=0
for idx in range(0,jogen+1,1):
    tmpten[0]=sum(weight_values[0][0:idx])
    tmpomo[0]=minimum_weight*idx

    jogen=min((W-tmpomo[0])//(minimum_weight+1),len(weight_values[1]))
    for idy in range(0,jogen+1,1):
        tmpten[1]=tmpten[0]+sum(weight_values[1][0:idy])
        tmpomo[1]=tmpomo[0]+(minimum_weight+1)*idy

        jogen=min((W-tmpomo[1])//(minimum_weight+2),len(weight_values[2]))
        for idz in range(0,jogen+1,1):
            tmpten[2]=tmpten[1]+sum(weight_values[2][0:idz])
            tmpomo[2]=tmpomo[1]+(minimum_weight+2)*idz

            kosuu=min((W-tmpomo[2])//(minimum_weight+3),len(weight_values[3]))
            tmpans=tmpten[2]+sum(weight_values[3][0:kosuu])
            #print(tmpans)
            ans=max(ans,tmpans)

print(ans)
