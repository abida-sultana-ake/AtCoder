ks = list(map(int, input().split()))
K = ks[0]
S = ks[1]

c = 0

for x in range(K+1):
    for y in range(K+1):
        z = S - x - y
        if K >= z and z >= 0:
            c += 1
print(c)
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 