A, B = map(int, input().split())

a = abs(A)
b = abs(B)
if a == b:
    print("Draw")
elif a < b:
    print("Ant")
else:
    print("Bug")
