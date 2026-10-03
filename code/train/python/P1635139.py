N=int(input())
isPrime = True
d=2
while d * d <= N:
  if N % d == 0:
    isPrime = False
  d += 1
print('YES' if isPrime else 'NO')