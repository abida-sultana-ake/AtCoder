# -*- coding: utf-8 -*-
# D - 感雨時刻の整理


N = int(input())
times_set = []
results = []
start_index = 0
end_index = 1
tmp_start = -1
tmp_end = -1

for i in range(N):
    start, end = map(int, input().split('-'))
    start -= start % 5
    end += ((4 + end % 5) // 5) * (5 - end % 5) + end % 100 // 56 * 40
    times_set.append([start, end])

times_set.sort()

for time_set in times_set:
    if tmp_start == -1:
        tmp_start = time_set[start_index]
        tmp_end = time_set[end_index]
    elif time_set[start_index] <= tmp_end:
        if tmp_end <= time_set[end_index]:
            tmp_end = time_set[end_index]
    else:
        results.append("{:04d}-{:04d}".format(tmp_start, tmp_end))
        tmp_start = time_set[start_index]
        tmp_end = time_set[end_index]

results.append("{:04d}-{:04d}".format(tmp_start, tmp_end))

for result in results:
    print(result)
