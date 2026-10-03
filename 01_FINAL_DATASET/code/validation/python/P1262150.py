from itertools import product
N,C = input(),input()
ans=1000
m = list(map(lambda b: ''.join(b), product('ABXY',repeat=2)))
for dic1 in m:
    for dic2 in m:
        ans = min(len(C.replace(dic1,'L').replace(dic2,'R')) ,ans)
print(ans)