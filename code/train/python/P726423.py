import math


obj_num, q_num = map(int, input().split())
XRH=[]
AB=[]

for N in range(obj_num):
    X,R,H = map(int, input().split())
    XRH.append((X,R,H))

for N in range(q_num):
    A,B = map(int, input().split())
    AB.append((A,B))

f=[]
for N in range(2*10**4+1):
    f.append(0)

def taiseki(X,R,H):
    global f
    for x in range(X,X+H):
        # print(x)
        f[x]+=R**2*math.pi*H/3*(((H+X-x)/H)**3-((H+X-x-1)/H)**3)

for N in range(obj_num):
    taiseki(XRH[N][0],XRH[N][1],XRH[N][2])

for N in range(q_num):
    sum=0
    for M in range(AB[N][0],AB[N][1]):
        sum+=f[M]
    print(sum)
