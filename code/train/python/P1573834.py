M = []
for i in range(4):
    M.append(list(map(str, input().split())))

for i in range(4):
    print(' '.join(M[-(i + 1)][::-1]))