A,B,C,K = map(int,input().split())
S,T = map(int,input().split())
if S + T < K:
    print(S * A + T * B )
else:
    print(S * A + T * B - (S + T) * C)
