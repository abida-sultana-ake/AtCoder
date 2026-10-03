M = input()
m = int(input())
l = len(M) + 1
for i in range(m):
    n, o = map(int, input().split())
    a = M[:n - 1]
    b = M[n - 1:o]
    b = b[::-1]
    c = M[o:]
    M = a + b + c
print(M)
