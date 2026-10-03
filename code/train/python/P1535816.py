s=str(input())
L=[0]*6
for i in range(97,97+6):
  L[i-97]=s.count(chr(i).upper())

print(' '.join(map(str, L)))