a = list(map(int,input().split(" ")))
if abs(a[0] - a[1]) < 2:
    print("Brown")
else:
    print("Alice")