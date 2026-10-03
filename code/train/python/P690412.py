m = round(1e9) + 7
n = int(input())
nexts = [set() for _ in range(n)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    nexts[a - 1].add(b - 1)
    nexts[b - 1].add(a - 1)
def count(cur, prev=-1):
    white, black = 1, 1
    for w, b in (count(i, cur) for i in nexts[cur] - {prev}):
        white = (white * (w + b)) % m
        black = (black * w) % m
    return white, black
print(sum(count(0)) % m)