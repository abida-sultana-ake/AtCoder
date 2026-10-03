N, M = map(int, input().split())
a=set()
b=set()
for i in range(M):
    k,l=map(int, input().split())
    if k==1:
        a.add(l)
    if l==N:
        b.add(k)
if a&b:
    print("POSSIBLE")
else:
    print("IMPOSSIBLE")
