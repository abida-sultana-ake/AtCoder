from copy import deepcopy


def solve(road, num, ans, n):
    pattern = 0
    test = deepcopy(road)
    for s in test:
        if num in s:
            s.remove(num)
    if len(ans) is n:
        return 1
    if len(test[num - 1]) == int(0):
        return 0
    else:
        for i in range(len(test[num - 1])):
            tmp = test[num - 1][i]
            if tmp is not 0:
                word = ans + str(tmp)
            pattern += solve(test, tmp, word, n)
    return pattern


N, M = [int(i) for i in input().split()]
town = []
for i in range(N):
    town.append(deepcopy([]))

for i in range(M):
    a, b = [int(i) for i in input().split()]
    if a is not 1 or b is not 1:
        town[a - 1].append(b)
        town[b - 1].append(a)
print(solve(town, 1, '1', N))
