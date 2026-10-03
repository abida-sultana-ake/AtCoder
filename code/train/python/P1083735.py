x = int(input())

cnt = 0
cnt += x // 11 * 2 # 5, 6
x = x % 11

if x >= 7:
    cnt += 2
elif x > 0:
    cnt += 1

print(cnt)