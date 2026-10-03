from operator import itemgetter
R, C, K = map(int, input().split())
N = int(input())
a_row = [0 for i in range(R)]
a_col = [0 for i in range(C)]
pos = []
result = 0

for i in range(N):
    r, c = map(int, input().split())
    a_row[r-1] += 1
    a_col[c-1] += 1
    pos.append((r-1, c-1))

a_row2 = sorted([(j, i) for i, j in enumerate(a_row) if j <= K], key=itemgetter(0))
a_col2 = sorted([(j, i) for i, j in enumerate(a_col) if j <= K], key=itemgetter(0), reverse=1)

for i in range(K+1):
    r, c = 0, 0
    while a_row2 and a_row2[-1][0] == K-i:
        a_row2.pop()
        r += 1
    while a_col2 and a_col2[-1][0] == i:
        a_col2.pop()
        c += 1
    result += r * c

for p in pos:
    s = a_row[p[0]] + a_col[p[1]]
    result += -1 if s==K else 1 if s==K+1 else 0

print(result)