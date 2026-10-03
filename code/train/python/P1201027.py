a, d = map(int, input().split())
ansA = (a+1)*d
ansB = a*(d+1)

if ansA >= ansB:
    print(ansA)
else:
    print(ansB)