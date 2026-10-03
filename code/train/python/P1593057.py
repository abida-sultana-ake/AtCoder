town = {}
total = 0
jurge = "atcoder"
N = int(input())
for i in range(N):
    s, p = input().split()
    town[s] = int(p)
    total += int(p)
for w in town:
    if town[w] > total // 2:
        jurge = w
        break
print(jurge)
