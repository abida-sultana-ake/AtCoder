
x1, y1, r = map(int, input().split())
x2, y2, x3, y3 = map(int, input().split())

if x2 <= x1 - r and x1 + r <= x3 and y2 <= y1 - r and y1 + r <= y3:
    print("NO")
else:
    print("YES")

def blue():
    if (x2 - x1) ** 2 + (y2 - y1) ** 2 > r ** 2:
        return True
    if (x2 - x1) ** 2 + (y3 - y1) ** 2 > r ** 2:
        return True
    if (x3 - x1) ** 2 + (y2 - y1) ** 2 > r ** 2:
        return True
    if (x3 - x1) ** 2 + (y3 - y1) ** 2 > r ** 2:
        return True
    return False

if blue():
    print("YES")
else:
    print("NO")
