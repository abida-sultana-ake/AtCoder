
S = input()
p = None
n = 0
for s in S:
    if s != p:
        n += 1
        p = s
print(n - 1)
  