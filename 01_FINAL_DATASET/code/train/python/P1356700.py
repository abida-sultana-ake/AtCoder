from math import ceil

n, a, b = map(int, input().rstrip("\n").split(" "))

h = []
total = 0
for i in range(n):
  value = int(input()) 
  h.append(value)
def solve(a, b):
  diff = a - b
  total = sum(h)

  h.sort()

  right = ceil(total // b)  + len(h)
  center = right // 2
  left = 0

  def check(b_count, h):
     b_total = b * b_count
     #print("b_total",b_total)
     #print("diff",diff)
     count = 0
     for value in h:
       remain = value - b_total
       #print("remain",remain)
       if remain > 0:
         count += ceil( remain  /  diff)
     return count - b_count

  result = 0
  while left < right:

     center = (left + right) // 2
     result = check(center, h)
     #print(left,right, result)
     if result < 0:
       right = center 
     elif result > 0:
       left= center + 1
     if result == 0:
       break
  center = (left + right) // 2
  #print(left,center,right)
  return center

print(solve(a, b))
#for b in range(1,a):
#  print(a, b ,"=", solve(a, b))
