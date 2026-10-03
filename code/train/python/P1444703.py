
X = int(input())

# for n in range(1000000):
#     # print((n * (n - 1) // 2))
#     if (n * (n - 1) // 2) >= X:
#         break


# n^2 - n - 2X <= 0
# n = (1 + sqrt(1 + 8X)) // 2
n = max(int((1 + (1 + 8 * X) ** 0.5) / 2) - 1, 0)
while True:
    if (n * (n - 1) // 2) >= X:
        break
    n += 1
print(n - 1)
