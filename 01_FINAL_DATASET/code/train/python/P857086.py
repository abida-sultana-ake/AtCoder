from sys import exit

def reads():
  return [int(x) for x in input().split()]

(N, A) = reads()
x = reads()

d = dict()

d[0] = 1

for i in range(N):
  for (s, N) in list(d.items()):
    k = s + x[i] - A
    d[k] = d.get(k, 0) + N

print(d[0]-1)
