
N, M = map(int, input().split())
ans = -1,-1,-1
flag = False

for y in [0, 1]:  # rouzin
    if flag:
        break
    for z in range(N - y + 1):
        if y * 3 + z * 4 == M - (N-y-z)*2:
            ans =  (N- y - z), y, z
            break

print(*ans)
