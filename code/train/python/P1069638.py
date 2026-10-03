K, S = map(int, input().split())

cnt = 0
for x in range(K+1):
    for y in range(K+1):
        z = S - x - y
        if z <= K:
            if z >= 0:
                cnt = cnt + 1

print(cnt)


