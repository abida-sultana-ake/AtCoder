N, T = [int(i) for i in input().split()]
t = [int(i) for i in input().split()]
x = T
for i in range(1, N):
    if t[i]-t[i-1] < T:
        x += T - abs(T - (t[i] - t[i - 1]))
    else:
        x += T
print(x)