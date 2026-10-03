N, T = list(map(int, input().split()))
A = list(map(int, input().split()))

minA = A[0]
benefit = 0
maxBenefit = 0
cost = 0

for i in range(N):
    if A[i] < minA:
        minA = A[i]
    else:
        benefit = A[i] - minA
        if benefit > maxBenefit:
            maxBenefit = benefit
            cost = 1
        elif benefit == maxBenefit:
            cost += 1

print(cost)