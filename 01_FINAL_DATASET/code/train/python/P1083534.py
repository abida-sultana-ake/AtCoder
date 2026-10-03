N = int(input())
A = list(map(int, input().split()))
D = {}
for i in A:
    if i in D:
        D[i] += 1
    else:
        D[i] = 1
cnt = 0
for k in D.keys():
    if D[k] % 2:
        D[k] = 1
    else:
        D[k] = 2
        cnt += 1
print(len(set(A)) - (cnt % 2))
