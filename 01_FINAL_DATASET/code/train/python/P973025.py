a = []
for i in range(2):
  a.append(input())

H1 = a[0].split()[0]
W1 = a[0].split()[1]

H2 = a[1].split()[0]
W2 = a[1].split()[1]

if H1 == H2 or H1 == W2 or W1 == H2 or W1 == W2:
  print("YES")
else:
  print("NO")
