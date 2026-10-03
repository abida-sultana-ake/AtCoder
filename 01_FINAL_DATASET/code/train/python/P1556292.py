def C(N, K, rates):
    rates = sorted(rates, reverse=True)
    rates = rates[:K]
    C = 0
    for k in range(len(rates) - 1, -1, -1):
        C = (C + rates[k]) / 2
    return C

N,K = [int(i) for i in input().split()]
l = [int(i) for i in input().split()]
print(C(N,K,l))