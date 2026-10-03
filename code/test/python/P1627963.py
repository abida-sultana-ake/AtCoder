import math

rain = [0 for x in range(int(24 * 60 / 5))]

N = int(input())
for i in range(N):
    s, e = map(int, input().split("-"))
    start_hour = int(s / 100)
    start_minute = math.floor((s - start_hour * 100) / 5) * 5
    start_block = int(start_hour * 60 / 5 + start_minute / 5)
    end_hour = int(e / 100)
    end_minute = math.ceil((e - end_hour * 100) / 5) * 5
    end_block = int(end_hour * 60 / 5 + end_minute / 5)
    for j in range(start_block, end_block):
        rain[j] = 1

is_rain = False
for i in range(len(rain)):
    if rain[i] == 1:
        if not(is_rain):
            is_rain = True
            hour = math.floor(i * 5 / 60)
            minute = i * 5 - hour * 60
            print("{0:02d}{1:02d}-".format(hour, minute), end="")
    else:
        if is_rain:
            is_rain = False
            hour = math.floor(i * 5 / 60)
            minute = i * 5 - hour * 60
            print("{0:02d}{1:02d}".format(hour, minute))
if is_rain:
    print("2400")
