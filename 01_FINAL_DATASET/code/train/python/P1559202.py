N = int(input())
src = list(map(int, input().split()))
MAX = 10**5

counts = [0 for i in range(MAX+1)]
for a in src:
    if a > 0: counts[a-1] += 1
    counts[a] += 1
    counts[a+1] += 1

print(max(counts))
