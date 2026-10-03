K=int(input())
N=50
a = list(range(N))
m = K // N
b = K % N
a=list(map(lambda x: x + m, a))
for i in range(b):
    a[i] += N
    for j in range(N):
        if j != i:
            a[j] -= 1
print(N)
print(' '.join(map(str,a)))