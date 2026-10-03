import math
def read():
    return int(input())

def reads(sep=None):
    return list(map(int, input().split(sep)))

def main():
    n, q = reads()
    a = [0] * (n+1)
    for _ in range(q):
        l, r, t = reads()
        a[l:r+1] = [t]*(r-l+1)
    for i in range(n):
        print(a[i+1])

main()
