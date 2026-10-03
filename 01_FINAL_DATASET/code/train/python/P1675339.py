N, W = map(int, input().split())
items = [tuple(map(int, input().split())) for i in range(N)]

memo = [{} for i in range(N + 1)]

memo[0] = {0: 0}
for i, (wi, vi) in enumerate(items):
    for w, v in memo[i].items():

        if w + wi <= W:
            memo[i + 1][w + wi] = max(memo[i + 1].get(w + wi, 0), v + vi)

        memo[i + 1][w] = max(memo[i + 1].get(w, 0), v)

print(max(memo[N].values()))
