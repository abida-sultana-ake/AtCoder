X, t = [int(x) for x in input().split()]

Rest = X - t
if Rest < 0:
  Rest = 0

print(Rest)