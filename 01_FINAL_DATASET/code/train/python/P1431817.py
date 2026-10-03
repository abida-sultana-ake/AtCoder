A, B = list(map(int, input().split(" ")))

if (A % 3 != 0) and (B % 3 != 0) and ((A+B) % 3 != 0):
    print("Impossible")
else:
    print("Possible")