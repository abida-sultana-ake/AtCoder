N, M, L = map(int,input().split())
P, Q, R = map(int,input().split())

per = ((N // P) * (M // Q) * (L // R))

per = max(per, ((N // P) * (M // R) * (L // Q)))
per = max(per, ((N // Q) * (M // P) * (L // R)))
per = max(per, ((N // Q) * (M // R) * (L // P)))
per = max(per, ((N // R) * (M // P) * (L // Q)))
per = max(per, ((N // R) * (M // Q) * (L // P)))

print(per)