import sys
sys.setrecursionlimit(int(10e8))

n, d, k = map(int, input().split())
days = []
for i in range(d):
    l, r = map(int, input().split())
    days.append([l, r])


def move(start, goal, day):
    mi = days[day][0]
    ma = days[day][1]
    day += 1
    if mi <= start <= ma:
        if mi <= goal <= ma:
            return day

        if start < goal:
            return move(ma, goal, day)
        elif start > goal:
            return move(mi, goal, day)
    else:
        return move(start, goal, day)

for j in range(k):
    s, t = map(int, input().split())
    print(move(s, t, 0))
