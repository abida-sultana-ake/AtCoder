N, T = map(int, input().split())
A = list(map(int, input().split()))
minv = A[0]
maxv = -1
L = [0]
for i in range(1, N):
    if A[i] - minv > maxv:
        L = [i]
        maxv = A[i] - minv
    elif A[i] - minv == maxv:
        L.append(i)
    minv = min(minv, A[i])
print(len(L))
