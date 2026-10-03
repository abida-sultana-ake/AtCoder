N, T = map(int, input().split())
t = list(map(int, input().split()))

# N, T= 4, 1000000000
# t = [0, 1000, 1000000, 1000000000]
# N, T = 9, 10
# t = [0, 3, 5, 7, 100, 110, 200, 300, 311]

total_time = 0
for i in range(N - 1):
    if t[i] + T < t[i + 1]:
        total_time += T
    else:
        total_time += t[i + 1] - t[i]
print(total_time + T)
