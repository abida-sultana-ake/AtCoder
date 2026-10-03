K, S = list(map(int, input().split()))
# ok_list = []
cnt = 0
for x in range(K + 1):
    if S - x > K:
        y_max = K + 1
    else:
        y_max = S - x + 1

    if S - x > 2 * K:
        continue
    else:
        # print(y_max, end=" ")
        pass

    for y in range(y_max):

        if S - (x + y) <= K:
            cnt += 1
print(cnt)