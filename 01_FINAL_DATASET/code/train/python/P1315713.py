A, B = map(int,input().split())

if abs(A) - abs(B) == 0:
    print("Draw")
elif abs(A) - abs(B) > 0:
    print("Bug")
else:
    print("Ant")