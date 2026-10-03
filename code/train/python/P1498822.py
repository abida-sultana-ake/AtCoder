N = int(input())
A = [int(input()) for i in range(N)]
A.sort(reverse=True)
max = A[0]

for a in A:
    if max > a:
        print(a)
        break