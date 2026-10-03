N = input().split()

A = int(N[0])
B = int(N[1])

if A%3 == 0:
    print("Possible")
elif B%3 == 0:
    print("Possible")
elif (A+B)%3 == 0:
    print("Possible")
else:
    print("Impossible")
