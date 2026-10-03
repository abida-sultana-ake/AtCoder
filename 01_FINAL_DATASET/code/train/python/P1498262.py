A, B, C, K = map(int, input().split())
S, T = map(int, input().split())


if S + T < K:
    print(A*S + B*T)
else:
    print((A-C)*S + (B-C)*T)
