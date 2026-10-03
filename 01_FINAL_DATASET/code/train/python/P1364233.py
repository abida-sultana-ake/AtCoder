A, B, C, K = [int(i) for i in input().split()]
S, T = [int(i) for i in input().split()]

if S + T < K:
    AF = A*S + B*T
    print(AF)
else:
    AFC = A*S - C*S
    AFA = B*T - C*T
    print(AFC + AFA)