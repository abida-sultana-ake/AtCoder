n,k = map(int,input().split())
t = []
for _ in range(n):
    t.append(list(map(int,input().split())))
for i in range(k**n):
    tmp = 0
    for j in range(n):
        tmp ^= t[j][i//(k**j)%k]
    if tmp==0:
        print("Found")
        break
else:
    print("Nothing")
