# coding: utf-8

n,t = [int(x) for x in input().rstrip().split(" ")]
push_times = [int(x) for x in input().rstrip().split(" ")]

total_duration = 0

for i in range(len(push_times)):
    if i == len(push_times) - 1:
        total_duration = total_duration + t
        break

    time_diff = (push_times[i+1] - push_times[i])
    if time_diff > t:
        total_duration = total_duration + t
    elif time_diff <= t:
        total_duration = total_duration + time_diff

print(total_duration)
