n,m = map(int,input().split())
x = list(map(int, input().split()))
y = list(map(int, input().split()))
MOD = 10**9 + 7

def bruteforce():
    total = 0
    for i in range(n-1):
        for j in range(i+1, n):
            for k in range(m-1):
                for l in range(k+1, m):
                    total += (x[j]-x[i]) * (y[l]-y[k])
    return total % MOD

def solve():
    width = 0
    for i in range(1, n):
        w = x[i] - x[i-1]
        width += w * (n-i)*i
        width %= MOD
    height = 0
    for i in range(1, m):
        h = y[i] - y[i-1]
        height += h * (m-i)*i
        height %= MOD

    return width * height % MOD

if __name__ == '__main__':
    # print(bruteforce())
    print(solve())