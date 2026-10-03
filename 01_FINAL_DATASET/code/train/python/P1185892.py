n,m=map(int,input().split())
st=[]
for i in range(n):
    a,b=map(int,input().split())
    st.append([a,b])

cp=[]
for i in range(m):
    c,d=map(int,input().split())
    cp.append([i+1,c,d])

Q=[]

for i in range(n):
    
    man = 10**8*4

    for j in range(m):

        if abs(cp[j][1]-st[i][0])+abs(cp[j][2]-st[i][1]) < man:
            man = abs(cp[j][1]-st[i][0])+abs(cp[j][2]-st[i][1])
            ans = cp[j][0]

    Q.append(ans)


for i in Q:
    print(i)