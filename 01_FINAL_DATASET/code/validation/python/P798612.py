A, K = [int(s) for s in input().split()]

M = A

if(K==0):
    t = 2000000000000-M
else:
    t = 0
    while (M < 2000000000000):
        M+=K * M + 1
        t+=1

print(t)