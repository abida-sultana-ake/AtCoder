import math
N = int(input())
k = int(math.sqrt(N))

sum = 0
ret = 0
for i in range(10 * k) :
    sum += i
    if sum >= N :
        ret = i
        break;
print(i)