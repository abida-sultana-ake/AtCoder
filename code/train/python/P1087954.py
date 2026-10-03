target_score = int(input())

cnt = target_score // 11 * 2
target_score = target_score % 11


if target_score == 0:
    print(cnt)
elif target_score <= 6:
    print(cnt + 1)
else:
    print(cnt + 2)
