def add_string(p,n,abc):
    t=3**n
    for i in range(t):
        if t>3:
            p.append(abc[int(i/(3**(n-1)))]+p[i%(3**(n-1))])
        else:
            p.append(abc[i])

    if n>1:
        del p[0:3**(n-1)]

def dic(p,n,abc):
    for i in range(int(n)):
        add_string(p,i+1,abc)

inp=input()

abc=["a","b","c"]
p=[]

dic(p,inp,abc)

for i in range(len(p)):
    print(p[i])