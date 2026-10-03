n = int(input())
coins = [int(input()) for i in range(n)]
ev = 0
for i in coins:
    factor = -1
    for j in coins:
        if i % j == 0:
            factor += 1
    if factor == 0:
        ev += 1
    elif factor % 2 == 1:
        ev += 0.5
    else:
        ev += (factor + 2) / (factor * 2 + 2)
print(ev)
