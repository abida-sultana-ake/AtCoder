import math
n = int(input())
s = int(math.sqrt(n))
for i in range(s,0,-1):
    if (n%i == 0):
        print(len(str(max(int(n/i), i))))
        break