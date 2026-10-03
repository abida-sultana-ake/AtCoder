N = int(input())
a = sorted(enumerate([tuple(map(int, input().split())) for i in [0]*N]), key=lambda x: x[1]) + [(-1, (10**9, 0))]

result = [None]*N
prev = a[0][1][0]
i = 0
while i < N:
    te = [0, 0, 0]
    j = i
    while prev == a[j][1][0]:
        te[a[j][1][1]-1] += 1
        j += 1
    num = j - i

    for k in range(i, j):
        index = a[k][0]
        m = a[k][1][1] - 1
        r = [te[(m+1)%3], te[(m-1)%3], te[m]-1]
        r[0] += i
        r[1] += N - j
        result[index] = " ".join(map(str, r))

    i = j
    prev = a[i][1][0]

for s in result:
    print(s)