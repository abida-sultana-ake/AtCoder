nm=input().split()
n=int(nm[0])
m=int(nm[1])

l1=[]
for i in range(m):
    l1.append(int(input()))

l2=[]
for i in range(n):
    l2.append(i+1)

cd=0
for i in l1:
    if i not in l2 :
        continue
    temp=l2[l2.index(i)]
    l2[l2.index(i)]=cd
    cd=temp
    
for i in range(n):
    print(l2[i])