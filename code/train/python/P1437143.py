order = [int(x) for x in input().split()]

n = int(input())

a = []

for _ in range(n):
  anum = int(''.join(str(order.index(int(c))) for c in input()))
  a.append(anum)

a.sort()

for anum in a:
  print(int(''.join(str(order[int(c)]) for c in str(anum))))