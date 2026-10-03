# coding=utf-8

# n:時刻の数
n = int(input())

# 時刻を格納
times = []
for i in range(n):
    times.append([int(i) for i in input().split("-")])

# 降り始めの時刻を格納
start = [times[i][0] for i in range(n)]

# 降り終わりの時刻を格納
end = [times[i][1] for i in range(n)]

# 降り始めの時刻を丸める
for i in range(len(start)):
    rem = start[i] % 10
    if 0 < rem < 5:
        start[i] -= rem
    elif 5 < rem < 10:
        start[i] = start[i] - rem + 5

# 降り終わりの時刻を丸める
for i in range(len(end)):
    rem = end[i] % 10
    if 55 < end[i] % 100 < 60:
        end[i] = end[i] - rem + 50
    elif 0 < rem < 5:
        end[i] = end[i] - rem + 5
    elif 5 < rem < 10:
        end[i] = end[i] - rem + 10

# 時刻を格納
times = [[start[i], end[i]] for i in range(n)]

# 降り始めの時刻が早い順に並び替え
times.sort()

# 重複を確認しながら順次出力
box = times[0]
for i in range(n - 1):
    if box[1] < times[i + 1][0]:
        print (str(box[0]).zfill(4) + "-" + str(box[1]).zfill(4))
        box = times[i + 1]
    elif times[i + 1][0] <= box[1] <= times[i + 1][1]:
        box[1] = times[i + 1][1]

# 残りを出力
print (str(box[0]).zfill(4) + "-" + str(box[1]).zfill(4))
