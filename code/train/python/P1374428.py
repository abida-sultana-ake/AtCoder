X, A, B = map(int, input().split())
if B <= A :
    print("delicious")
else:
    if -A +B <= X :
        print("safe")
    else:
        print("dangerous")