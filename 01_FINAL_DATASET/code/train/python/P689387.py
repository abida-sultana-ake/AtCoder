N = int(input().strip())
min=100000
max=0
a = [100000 for i in range(N)]
b = {}
for i in range(N):
    a[i] = int(input().strip())
    if(a[i] in b):
        b[a[i]]+=1
    else:
        b[a[i]]=1

n=0
for i in sorted(b):
    b[i]=n
    n+=1

for i in range(N):
    print(str(b[a[i]]))
