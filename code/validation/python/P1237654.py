x, y = input().split()
x, y = int(x), int(y)

if -1 <= x - y <= 1:
  print("Brown")
else:
  print("Alice")
