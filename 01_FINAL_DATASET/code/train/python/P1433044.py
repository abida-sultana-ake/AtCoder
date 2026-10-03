m, n = map(int, input().split())
kougeki = (m + 1) * n
bougyo = m * (n + 1)
if kougeki >= bougyo:
    print(kougeki)
else:
    print(bougyo)
