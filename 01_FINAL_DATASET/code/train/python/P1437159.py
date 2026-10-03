
order = [int(x) for x in input().split()]
n = int(input())
 
a = []
 
for _ in range(n):
  a.append(int(''.join(str(order.index(int(digit))) for digit in input())))
 
a.sort()
 
for num in a:
  print(int(''.join(str(order[int(digit)]) for digit in str(num))))