N,T = map(int,input().split())
last, time = 0,-T
for temp in map(int,input().split()):
    if temp - last < T:
        time += T - (temp - last)
    last = temp
print(N*T-time)