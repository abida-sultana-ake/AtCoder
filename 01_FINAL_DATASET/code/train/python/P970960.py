from collections import Counter
s = input()
cnt_wb = Counter(s)
# 全部同じ色のとき
if cnt_wb["W"] == len(s) or cnt_wb["B"] == len(s):
    print(0)
else:
    prev = s[0]
    cnt = 0
    for i in range(1, len(s)):
        if prev != s[i]:
            prev = s[i]
            cnt += 1
    print(cnt)