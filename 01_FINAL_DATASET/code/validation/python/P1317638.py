E = set(input().split())
B = input()
L = set(input().split())

tog = len(L - E)

if tog == 0:
    print(1)
elif tog == 1:
    if B in L:
        print(2)
    else:
        print(3)
elif tog == 2:
    print(4)
elif tog == 3:
    print(5)
else:
    print(0)