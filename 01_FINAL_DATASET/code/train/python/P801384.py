from itertools import count

x = int(input())

a = x ** 2
b = (x+1) ** 2

result = 0

12345

for i in range(len(str(a))//2, -1, -1):
  n = (a // 100**i) + int(a % 100**i != 0)
  if n * 100**i < b:
    print(n)
    break
