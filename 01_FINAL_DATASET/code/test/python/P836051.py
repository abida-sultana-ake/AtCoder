import math
N = int(input())
a = [int(i) for i in input().strip().split(" ")]

a_h = math.ceil(sum(a) / len(a))
a_l = math.floor(sum(a) / len(a))

d_h = sum([(a_h-i)**2 for i in a])
d_l = sum([(a_l-i)**2 for i in a])

print(min(d_h,d_l))
