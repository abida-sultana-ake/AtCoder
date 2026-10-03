N=int(input())
for a in range(1,10):
  for b in range(1, 10):
    if a * b == 2025-N:
      print(a, "x", b)