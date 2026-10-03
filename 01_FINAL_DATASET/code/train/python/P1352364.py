a, b = (int(i) for i in input().split())
a = a % 12
a = (a+b/60)*30
b *= 6
s  = abs(a-b)
if s > 180 : s = 360 - s
print(s)