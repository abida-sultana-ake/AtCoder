
b = [int(x) for x in input().split()]
n = int(input())
 
a = []
 
for _ in range(n):
  a.append(int(''.join(str(b.index(int(digit))) for digit in input())))
 
a.sort()
 
for num in a:
  print(int(''.join(str(b[int(digit)]) for digit in str(num))))
