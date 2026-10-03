import functools
import math

n, m = [int(x) for x in input().split()]

info = []
for _ in range(m):
    info.append([int(x) for x in input().split()])

# ここから処理

def memoize(obj):
    cache = obj.cache = {}

    @functools.wraps(obj)
    def memoizer(*args, **kwargs):
        key = str(args) + str(kwargs)
        if key not in cache:
            cache[key] = obj(*args, **kwargs)
        return cache[key]
    return memoizer

@memoize
def number_of_ranking(numbers):
    if len(numbers) == 1:
       return 1

    result = 0
    for i in range(len(numbers)):
        if all([x[0] not in numbers for x in info if numbers[i] == x[1]]):
            result += number_of_ranking(numbers[:i] + numbers[i + 1:])
    return result

print(number_of_ranking(list(range(1, n + 1))))
