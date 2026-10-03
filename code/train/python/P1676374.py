def calc(m):
    kyuryous = []
    for buka in bukas[m]:
        kyuryous.append(calc(buka))
    if len(kyuryous) == 0:
        return 1
    else:
        return max(kyuryous) + min(kyuryous) + 1

n = int(input())

bs = [int(input())-1 for i in range(n-1)]

bukas = [[] for _ in range(n)]

for i, b in enumerate(bs):
    bukas[b].append(i+1)

print(calc(0))