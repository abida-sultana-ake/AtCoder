import math

class Cone(object):
    def __init__(self, x, r, h):
       self.x = x
       self.r = r
       self.h = h

    def coneVolume(self):
        return self.r ** 2 * math.pi * self.h / 3

    def volume(self, low, high):
        if self.x + self.h <= low or high <= self.x:
            return 0
        if low <= self.x and  self.x + self.h <= high:
            return self.coneVolume()
        if low <= self.x < high < self.x + self.h:
            hcube = self.h ** 3
            return self.coneVolume() * (hcube - (self.x + self.h - high) ** 3) / hcube
        if self.x < low < self.x + self.h <= high:
            return self.coneVolume() * (self.x + self.h - low) ** 3 / self.h ** 3
        if self.x < low and high < self.x + self.h:
            h2 = self.x + self.h - low
            r2 = self.r * h2 / self.h
            h2cube = h2 ** 3
            return  r2 ** 2 * math.pi * h2 / 3 * (h2cube - (self.x + self.h - high) ** 3) / h2cube

N, Q = map(int, input().split())

C = []
for i in range(N):
    x, r, h = map(int, input().split())
    C.append(Cone(x, r, h))

for i in range(Q):
    ans = 0
    low, high = map(int, input().split())
    for j in range(N):
        ans += C[j].volume(low, high)
    print(ans)
