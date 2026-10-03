B=input().split()
N=int(input())
A=[input() for _ in [1]*N]

d=dict()
for a in A:
    l=len(a)
    d[a]=sum([B.index(a[i])*10**(l-i-1) for i in range(l)])   

for i in [i[0] for i in sorted(d.items(),key=lambda x:x[1])]:
    for a in [a for a in A if a==i]:
        print(a)