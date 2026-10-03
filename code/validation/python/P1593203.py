N = int(input())
sm = 0
for i in range(1, 10):
    for j in range(1, 10):
        sm += i * j
a = sm - N
for i in range(1, 10):
    for j in range(1, 10):
        if i * j == a:
            print("{} x {}".format(i, j))