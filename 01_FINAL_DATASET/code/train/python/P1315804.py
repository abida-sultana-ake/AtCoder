N, M, L = map(int,input().split())
P, Q, R = map(int,input().split())

put = (N // P) * (M // Q) * (L // R)

put = max(put, (N // P) * (M // R) * (L // Q))
put = max(put, (N // Q) * (M // P) * (L // R))
put = max(put, (N // Q) * (M // R) * (L // P))
put = max(put, (N // R) * (M // P) * (L // Q))
put = max(put, (N // R) * (M // Q) * (L // P))

print(put)