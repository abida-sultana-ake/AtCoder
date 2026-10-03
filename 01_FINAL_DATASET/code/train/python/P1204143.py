def mDistance(a, b):
    axisDist = [abs(x0 - x1) for x0, x1 in zip(a, b)]
    return(sum(axisDist))


N, M = map(int, input().split())
An, Am = ([], [])

while len(An) < N:
    An.append(tuple(map(int, input().split())))

while len(Am) < M:
    Am.append(tuple(map(int, input().split())))

for a in An:
    B = map(lambda b: mDistance(a, b), Am)
    I, _ = min(enumerate(list(B)), key=lambda b: b[1])
    print(I + 1)
