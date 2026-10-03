import math

a = int(input())
b = int(input())
m = int(input())

for x in range(m,(m+a*b)):
    if x%a==0 and x%b==0:
        print(x)
        break