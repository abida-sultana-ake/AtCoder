from collections import Counter
input()
c = Counter([min(int(i)//400,8) for i in input().split()])
ans = 0
for i in range(8):
 ans += bool(c[i])
print(max(ans,1),ans+c[8])