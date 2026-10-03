A,B,K,L = list(map(int, input().split()))

sc = int(K/L)
rest = int(K - sc*L)
res = rest*A+sc*B
print(min(res, sc*B+B))
