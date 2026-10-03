N = int(raw_input())
Ts = map(int, raw_input().split())
T = sum(Ts)
M = int(raw_input())
for i in range(M):
    P, X = map(int, raw_input().split())
    print (T - Ts[P-1] + X)