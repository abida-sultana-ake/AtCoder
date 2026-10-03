a,b,c=map(int,input().split())
n=[]
for x in range(1,b+1):
    n.append(a*x)

for x,y in enumerate(n):
    if y%b==c:
        print("YES")
        break
else:
        print("NO")