s = [input() for i in range(12)]

res = 0
for i in range(12):
  if s[i].find("r") != -1:
    res += 1
print(res)
