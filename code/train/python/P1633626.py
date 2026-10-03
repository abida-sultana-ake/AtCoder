X, A, B = [int(n) for n in input().split()]
if B <= A:
  print("delicious")
elif B<=A+X:
  print("safe")
else:
  print("dangerous")