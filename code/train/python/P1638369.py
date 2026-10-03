N = int(input())
str_line = input()

count = [0, 0, 0, 0]
for ci in str_line:
  count[int(ci) - 1] += 1

t = [(count[0], 1), (count[1], 2), (count[2], 3), (count[3], 4)]
mx = max(t)[0]
mn = min(t)[0]
print(mx, mn)
