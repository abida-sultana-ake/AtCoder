n = int(input())

lst = []

for i in range(n):
    lst.append(list(input()))


lst[0].sort()
sta = list(set(lst[0]))
sta.sort()
res = []

for i in sta:
    min = 100
    for j in range(n):
        if lst[j].count(i) < min:
            min = lst[j].count(i)
    res.append(min)

for i in range(len(sta)):
    for j in range(res[i]):
        print(sta[i], end = "")
