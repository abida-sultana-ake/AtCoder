N, A, B = map(int, input().split())

num = N % (A + B)
if num - A <= 0 and num != 0:
    print("Ant")
else:
    print("Bug")
