from math import factorial

N, D = [int(_) for _ in input().split()]
X, Y = [int(_) for _ in input().split()]

ans = 0
if X % D == 0 or Y % D == 0:
    nx_p = abs(X // D)
    ny_p = abs(Y // D)
    r = N - nx_p - ny_p

    if r % 2 == 0:
        nx_n = 0
        ny_n = 0

        C = []
        for i in range(N + 1):
            tmp = []
            for j in range(i + 1):
                if j == 0 or j == i:
                    tmp.append(1)
                else:
                    tmp.append(C[i-1][j-1] + C[i-1][j])
            C.append(tmp)

        for i in range(r // 2 + 1):
            n1 = nx_p + i
            n2 = nx_n + i
            n3 = ny_p + r // 2 - i
            n4 = ny_n + r // 2 - i

            # ans += factorial(N) / factorial(n1) / factorial(n2) / factorial(n3) / factorial(n4) / (4 ** N)
            ans += C[N][n1] * C[N-n1][n2] * C[N-n1-n2][n3] / (4**N)

print(ans)


