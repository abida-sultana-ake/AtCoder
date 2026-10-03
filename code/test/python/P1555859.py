N = int(input()) % 30
c = list(range(1, 7))

for i in range(N):
    c[i % 5], c[i % 5 + 1] = c[i % 5 + 1], c[i % 5]

print(''.join(map(str, c)))
