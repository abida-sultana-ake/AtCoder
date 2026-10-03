E = set(input().split())
B = input()
L = set(input().split())

per = len(L - E)

if per == 0:
    print(1)
elif per == 1:
    if B in L:
        print(2)
    else:
        print(3)
elif per == 2:
    print(4)
elif per == 3:
    print(5)
else:
    print(0)