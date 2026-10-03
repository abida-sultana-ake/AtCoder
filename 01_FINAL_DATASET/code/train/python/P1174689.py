N,K = map(int,input().split())
D = list(map(int,input().split()))
for i in range(N*10):
    n = str(N + i)
    ok = True
    for j in D:
        if n.find(str(j)) != -1:
            ok = False
            break
    if ok:
        print(n)
        break