pos = list(map(int, input().split()))
sx = pos[0]
sy = pos[1]
tx = pos[2]
ty = pos[3]

dx = tx - sx
dy = ty - sy

ans = ''
for i in range(dy):
    ans += 'U'
for i in range(dx):
    ans += 'R'
for i in range(dy):
    ans += 'D'
for i in range(dx+1):
    ans += 'L'
for i in range(dy+1):
    ans += 'U'
for i in range(dx+1):
    ans += 'R'
ans += 'DR'
for i in range(dy+1):
    ans += 'D'
for i in range(dx+1):
    ans += 'L'
ans += 'U'

print(ans)