from cmath import pi
from functools import reduce
class cone:
    def __init__(self,x,r,h):
        self.left = x
        self.right = x + h
        self.height = h
        self.vol_base = r ** 2 * pi / (3 * h ** 2)
    def extract(self,a, b):
        if a >= self.right or b <= self.left:
            return 0.0
        plus = min(self.right - a, self.height)
        minus = max(self.right - b, 0)
        vol = self.vol_base * (plus ** 3 - minus ** 3)
        return vol

if __name__ == "__main__":
    N, Q = map(int, input().split())
    cones = []
    for i in range(N):
        x,r,h = map(int,input().split())
        cones.append(cone(x,r,h))
    for i in range(Q):
        a,b = map(int,input().split())
        vol = sum(map(lambda c: c.extract(a,b), cones))
        print(vol)
