N,M,D = map(int, input().split())
A = list(map(int, input().split()))

arr1 = [i for i in range(N)]
arr2 = [i for i in range(N)]
for a in reversed(A):
    arr1[a], arr1[a-1] = arr1[a-1], arr1[a]

tmp = [i for i in range(N)]
n = 0
while True:
    if (D >> n) & 1:
        for i in range(N):
            tmp[i] = arr1[tmp[i]] if n % 2 == 0 else arr2[tmp[i]]
    n += 1
    if (D >> n) == 0: break
    for i in range(N):
        if n % 2 == 0:
            arr1[i] = arr2[arr2[i]]
        else:
            arr2[i] = arr1[arr1[i]]

for a in tmp: print(a+1)
