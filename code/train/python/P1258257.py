n, w = map(int, input().split())

wv = [list(map(int, input().split())) for i in range(n)]
cache = [{} for x in range(n)]

def solve(i, w):
    if i >= n:
        return 0

    cache_value = cache[i].get(w)
    if cache_value:
        return cache_value

    if w - wv[i][0] >= 0:
        value = max(solve(i + 1, w), solve(i + 1, w - wv[i][0]) + wv[i][1])
        cache[i][w] = value
        return value
    else:
        value = solve(i + 1, w)
        cache[i][w] = value
        return value

print(solve(0, w))
