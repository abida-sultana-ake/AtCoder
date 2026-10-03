xy = list(map(int , input().split()))
x = xy[0]
y = xy[1]
if abs(x - y) <= 1:
    print("Brown")
else:
    print("Alice")