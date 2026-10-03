f = [0] * 2048
f[1] = 1
for i in range(2, 2048):
    f[i] = f[i-1] * i

def c(n, r):
    if r <= 0 or n <= r: return 1
    return f[n] // (f[n-r] * f[r])

def solve(N, D, X, Y):
    if X % D != 0: return 0.0
    if Y % D != 0: return 0.0
    X = X // D
    Y = Y // D
    M = N - X - Y
    if M < 0 or M % 2 != 0: return 0.0
    
    res = 0
    i = 0
    while i <= M:
      x = i // 2
      y = (M - i) // 2
      res += c(X + 2 * x, x) * c(Y + 2 * y, y) * c(N, X+2*x)
      i += 2
    if res * (10 ** 10) < 4 ** N:
        return 0
    for i in range(2 * N):
      if 2 * N - i >= 40:
        res //= 2
      else:
        res /= 2
    return res

N,D = map(int,input().split())
X,Y = map(int,input().split())

print(solve(N, D, abs(X), abs(Y)))
