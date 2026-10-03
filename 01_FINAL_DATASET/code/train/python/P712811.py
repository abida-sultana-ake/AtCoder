from math import pi

class Cone:
    def __init__(self, x, r, h):
        self.a = x
        self.b = x + h
        self.r = r
        self.h = h

    @classmethod
    def calc(self, s, h):
        return s * h / 3

    def get(self, a, b):
        if b <= self.a or self.b <= a:
            return 0
        a, b = max(self.a, a), min(self.b, b)       
        ah = self.b - a
        bh = self.b - b
        ar = ah / self.h * self.r
        if b == self.b:
            return Cone.calc(ar ** 2 * pi, ah)
        else:
            br = bh / self.h * self.r
            return Cone.calc(ar ** 2 * pi, ah) - Cone.calc(br ** 2 * pi, bh)

    def __repr__(self):
        return "[{}, {}], r = {}, h = {}".format(self.a, self.b, self.r, self.h)

if __name__ == "__main__":
    N, Q = list(map(int, input().split()))
    cones = [Cone(*list(map(int, input().split()))) for _ in range(N)]
    for _ in range(Q):
        a, b = list(map(int, input().split()))
        print(sum(c.get(a, b) for c in cones))
    
