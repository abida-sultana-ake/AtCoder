
x1, y1, r = map(int, input().split())
x2, y2, x3, y3 = map(int, input().split())

ans1 = True
ans2 = False

if x2 <= x1 - r and x1 + r <= x3 and y2 <= y1 - r and y1 + r <= y3:
    ans1 = False


for x in [x2, x3]:
    for y in [y2, y3]:
        if pow(x1 - x, 2) + pow(y1 - y, 2) > pow(r, 2):
            ans2 = True
            break


print('YES' if ans1 else 'NO')
print('YES' if ans2 else 'NO')
