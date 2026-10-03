from math import floor

def c(n,x):
    ret = [-1] * n
    for i in range(n):
        if i%2 == 0: idx = floor(i/2) 
        else: idx = n - 1 - floor(i/2)
        ret[idx] = x[n-i-1] 
    return " ".join([str(i) for i in ret])

def main():
    n = int(input())
    x = list(map(int, input().split()))
    print(c(n,x))

def test():
    print( c(4,[1,2,3,4]))
    print( c(6,[0,6,7,6,7,0]))
main()
