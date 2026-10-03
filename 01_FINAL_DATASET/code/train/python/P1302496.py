abcde = list(map(int, input().split()))

results = []


def f(i, count, result):
    if count == 3:
        results.append(result)
        return
    if i >= len(abcde):
        return
    else:
        f(i + 1, count + 1, result + abcde[i])
        f(i + 1, count, result)

f(0, 0, 0)
print(sorted(results, reverse=True)[2])
