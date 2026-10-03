S = input().rstrip()
T = int(input().rstrip())
 
a = abs(S.count('U') - S.count('D')) + abs(S.count('L') - S.count('R'))
x = S.count('?')
if T == 1:
  a += x
else:
  if a > x:
    a -= x
  else:
    x -= a
    a = x % 2

print(a)