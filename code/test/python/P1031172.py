line = input().split()

a = int(line[0])
op = line[1]
b = int(line[2])

if op == "+":
  print(a + b)
else:
  print(a - b)
