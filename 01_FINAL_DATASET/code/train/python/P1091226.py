_ = input()
L = list(map(int, input().split()))
if len(set(L))%2 == 0:
  print(len(set(L)) - 1)
else:
  print(len(set(L)))
