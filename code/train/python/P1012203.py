line = list(input())

if line[0] == line[-1]:
  if len(line) % 2 == 0:
    print("First")
  else:
    print("Second")
else:
  if len(line) % 2 == 0:
    print("Second")
  else:
    print("First")