import bisect

class Box:
  def __init__(self, H, W):
    self.H = H
    self.W = W

N = int(input())
BOX = [Box(*map(int, input().split())) for i in range(N)]
BOX.sort(key = lambda b: b.W, reverse = True)
BOX.sort(key = lambda b: b.H)

dp = [BOX[0].W]
for box in BOX:
  if dp[-1] < box.W:
    dp.append(box.W)
  else:
    dp[bisect.bisect_left(dp, box.W)] = box.W
print(len(dp))
