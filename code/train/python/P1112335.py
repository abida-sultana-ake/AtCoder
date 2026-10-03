ame = set()
r, c, k = map(int, input().split())
row_n = [0] * (r + 1)
col_n = [0] * (c + 1)
row_nn = [0] * 100001
col_nn = [0] * 100001
n = int(input())

for _ in range(n):
    rr, cc = map(int, input().split())
    row_n[rr] += 1
    col_n[cc] += 1
    ame.add((rr, cc))

for i in range(1, r + 1):
    row_nn[row_n[i]] += 1

for i in range(1, c + 1):
    col_nn[col_n[i]] += 1

ans = 0
for i in range(k + 1):
    ans += row_nn[i] * col_nn[k - i]

for rr, cc in ame:
    num = row_n[rr] + col_n[cc]
    if num == k:
        ans -= 1
    if num == k + 1:
        ans += 1

print(ans)
