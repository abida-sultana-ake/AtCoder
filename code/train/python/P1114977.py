N = int(input())

x = 800 * N
piyo = 0

for i in range(1, N+1):
    if i % 15 == 0:
        piyo += 1

y = 200 * piyo

print(x-y)