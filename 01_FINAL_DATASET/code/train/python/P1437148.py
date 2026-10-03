order = [int(x) for x in input().split()]
n = int(input())

a = []

for _ in range(n):
  a.append(int(''.join(str(order.index(int(c))) for c in input())))

a.sort()

for anum in a:
  print(int(''.join(str(order[int(c)]) for c in str(anum))))