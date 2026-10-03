N = int(input())
prev = '.'*9
ans = 0
for i in range(N):
    now = input()
    for j in range(9):
        if now[j] == 'x':
            ans += 1
        elif now[j] == 'o' and prev[j] != 'o':
            ans += 1
    prev = now
print(ans)
