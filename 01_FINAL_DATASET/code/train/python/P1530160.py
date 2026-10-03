N,D = map(int, input().split())
X,Y = map(int, input().split())

mem = [[0 for j in range(N+1)] for i in range(N+1)]
mem[0][0] = 1.0
for i in range(1,N+1):
    for j in range(i+1):
        mem[i][j] = (mem[i-1][j] + (0 if j == 0 else mem[i-1][j-1])) / 2
# mem[i][j] == 1 / iCj

def solve():
    ans = 0.0
    if abs(X) % D != 0 or abs(Y) % D != 0: return ans
    xn = abs(X) // D
    yn = abs(Y) // D
    if xn + yn > N or (xn + yn) % 2 != N % 2 : return ans
    for h in range(xn, N+1, 2):
        v = N - h
        if v < yn: break
        xforward = xn + (h - xn) // 2
        yforward = yn + (v - yn) // 2
        ans += mem[N][h] * mem[h][xforward] * mem[v][yforward]
    return ans
print(solve())
