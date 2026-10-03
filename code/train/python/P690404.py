N = int(input())
A = []
for i in range(N):
    A.append(int(input()))
I = list(range(N))
I.sort(key=lambda i: A[i])

p = -1
c = 0
m = dict()
for i in I:
    if A[i] != p:
        m[A[i]] = c
        c += 1
        p = A[i]

for i in range(N):
    print(m[A[i]])
