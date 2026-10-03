x, y, tx, ty = [int(i) for i in input().split()]
ans = []
for i in range(ty - y):
    ans.append('U')
for i in range(tx - x):
    ans.append('R')
for i in range(ty - y):
    ans.append('D')
for i in range(tx - x + 1):
    ans.append('L')
for i in range(ty - y + 1):
    ans.append('U')
for i in range(tx - x + 1):
    ans.append('R')
ans.append('DR')
for i in range(ty - y + 1):
    ans.append('D')
for i in range(tx - x + 1):
    ans.append('L')
ans.append('U')
ans = ''.join(ans)
print(ans)
