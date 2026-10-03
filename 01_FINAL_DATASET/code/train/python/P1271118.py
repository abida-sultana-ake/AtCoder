import math
N = int(input())
d = N < 4**int(math.log(N, 4))*2
t = True
n = 1
while True:
    if t:
        n = n*2+1 if d else n*2
    else:
        n = n*2 if d else n*2+1
    if n > N:
        print("Aoki" if t else "Takahashi")
        break
    t = not t