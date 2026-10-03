E = set(input().split())
B = input()
L = set(input().split())

con = len(L - E)

if con == 0:
    print(1)
elif con == 1:
    if B in L:
        print(2)
    else:
        print(3)
elif con == 2:
    print(4)
elif con == 3:
    print(5)
else:
    print(0)