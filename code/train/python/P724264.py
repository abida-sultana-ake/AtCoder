class Circle:
    def __init__(self, cx, cy, r):
        self.cx = cx
        self.cy = cy
        self.r = r
    def include(self, x, y):
        return self.r ** 2 >= (x - self.cx) ** 2 + (y - self.cy) ** 2
    def vertices(self):
        return [
            [self.cx - self.r, self.cy],
            [self.cx + self.r, self.cy],
            [self.cx, self.cy - self.r],
            [self.cx, self.cy + self.r],
        ]

class Rectangle:
    def __init__(self, xl, yt, xr, yb):
        self.xl = xl
        self.yt = yt
        self.xr = xr
        self.yb = yb
    def include(self, x, y):
        return self.xl <= x <= self.xr and self.yt <= y <= self.yb
    def vertices(self):
        return [
            [self.xl, self.yt],
            [self.xl, self.yb],
            [self.xr, self.yt],
            [self.xr, self.yb]
        ]

c = Circle(*map(int, input().split()))
r = Rectangle(*map(int, input().split()))

red = not all(map(lambda a:r.include(*a), c.vertices()))
blue = not all(map(lambda a:c.include(*a), r.vertices())) 

for ans in [red, blue]:
    if ans:
        print("YES")
    else:
        print("NO")