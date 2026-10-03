Ax, Ay, Bx, By = [int(_) for _ in input().split()]

N = int(input())
P = [[int(x) for x in input().split()] for _ in range(N)]
P.append(P[0])

res = 0

X, Y = Bx - Ax, By - Ay

for i in range(N):
    a, b = P[i]
    c, d = P[i + 1]

    Xt, Yt = c - a, d - b

    t1 = X * (b - Ay) - Y * (a - Ax)
    t2 = X * (d - Ay) - Y * (c - Ax)
    t3 = Xt * (Ay - b) - Yt * (Ax - a)
    t4 = Xt * (By - b) - Yt * (Bx - a)

    if t1 * t2 < 0 and t3 * t4 < 0:
        res += 1

print(res // 2 + 1)
