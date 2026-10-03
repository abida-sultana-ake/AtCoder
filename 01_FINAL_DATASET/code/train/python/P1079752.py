N, A, B = list(map(int, input().split()))
inputs = list(map(int, input().split()))

xi = []
xi.append(inputs[0])
hirou = 0

for i in range(1, N):
    xi.append(inputs[i])
    diff = xi[i] - xi[i-1]
    if diff * A > B:
        hirou += B
    else:
        hirou += A * diff

print(hirou)
