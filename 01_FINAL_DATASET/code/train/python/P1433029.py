m, n, o, p = map(int, input().split())
TAKAHASHI = n / m
AOKI = p / o
if AOKI > TAKAHASHI:
    print("AOKI")
elif AOKI < TAKAHASHI:
    print("TAKAHASHI")
else:
    print("DRAW")
