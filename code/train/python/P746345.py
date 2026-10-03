from bisect import bisect

def read():
  return map(int, input().split())

(N,) = read()

box = [0] * N
for i in range(N):
  (w, h) = read()
  box[i] = (w, -h)

box.sort()
que = [(0, 0)]

for (w, h) in box:
  h = -h
  i = bisect(que, (h, 0))
  (_,  c) = que[i-1]
  if i < len(que):
    (h2, d) = que[i]
    if d == c + 1:
      que.pop(i)
  que.insert(i, (h, c+1))

print(que[-1][1])
