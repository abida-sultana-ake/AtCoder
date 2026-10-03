def is_clear(med,bal,n,nlist):
    for i in range(n):
        nlist[i] = 0
    for i in bal:
        tmp = (med-i[0])//i[1]
        if tmp < 0: return False
        nlist[min(tmp,n-1)] += 1
    if nlist[0] > 1: return False
    for i in range(1,n):
        nlist[i] += nlist[i-1]
        if nlist[i] > i+1: return False
    return True

def main():
    n = int(input())
    bal = [list(map(int,input().split())) for _ in range(n)]
    nlist = [0]*n
    lo = 0
    hi = 10**16
    while lo+1 < hi:
        med = (lo+hi)//2
        if is_clear(med,bal,n,nlist):
            hi = med
        else:
            lo = med
    print(hi)

main()
