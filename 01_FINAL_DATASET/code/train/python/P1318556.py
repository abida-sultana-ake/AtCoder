N, M, L = map(int,input().split())
P, Q, R = map(int,input().split())

squ = (N // P) * (M // Q) * (L // R)

squ = max([squ, (N // P) * (M // R) * (L // Q)])
squ = max([squ, (N // Q) * (M // P) * (L // R)])
squ = max([squ, (N // Q) * (M // R) * (L // P)])
squ = max([squ, (N // R) * (M // P) * (L // Q)])
squ = max([squ, (N // R) * (M // Q) * (L // P)])

print(squ)
