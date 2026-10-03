N = int(input())
C = [int(input()) for i in range(N)]
D = [0] * N
for i in range(N):
    for j in range(N):
        if C[i] % C[j] == 0:
            D[i] += 1

ans = 0.0
p = [((D[i]+1)//2)/D[i] for i in range(N)]
print("{:.20f}".format(sum(p)))