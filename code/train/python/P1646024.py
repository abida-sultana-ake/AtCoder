from collections import defaultdict
N = int(input())
a = [int(i) for i in input().split(" ")]
dic_num=defaultdict(int)

for i in a:
    dic_num[i] += 1
ans = -1
for X in range(min(a),max(a)+1):
    tmp = (dic_num[X-1] + dic_num[X] + dic_num[X+1])
    if ans < tmp:
        ans = tmp
print(ans)