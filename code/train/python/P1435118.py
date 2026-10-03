a = input()
s = list(a)
n = len(a)
s.sort()
t = [0] * 6
for i in range(n) :
    if s[i] == 'A' :
      t[0] += 1
    if s[i] == 'B' :
      t[1] += 1
    if s[i] == 'C' :
      t[2] += 1
    if s[i] == 'D' :
      t[3] += 1
    if s[i] == 'E' :
      t[4] += 1
    if s[i] == 'F' :
      t[5] += 1

print(t[0], end = ' ')
print(t[1], end = ' ')
print(t[2], end = ' ')
print(t[3], end = ' ')
print(t[4], end = ' ')
print(t[5])