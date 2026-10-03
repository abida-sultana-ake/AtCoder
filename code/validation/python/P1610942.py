E = set(map(int, input().split()))
B = int(input())
L = set(map(int, input().split()))
cnt = len(E&L)
if cnt == 6:
    print(1)
elif cnt == 5:
    if B in L:
        print(2)
    else:
        print(3)
elif cnt == 4:
    print(4)
elif cnt == 3:
    print(5)
else:
    print(0)