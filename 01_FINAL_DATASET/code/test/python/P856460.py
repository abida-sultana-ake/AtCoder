import collections

w = input()
flg = 0
count_dict = collections.Counter(w)
for k, v in count_dict.items():
    if v % 2 != 0:
        flg = 1
        break
if flg == 1:
    print('No')
else:
    print('Yes')
