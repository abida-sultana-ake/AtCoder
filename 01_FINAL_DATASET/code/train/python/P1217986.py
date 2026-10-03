import sys

ostr = sys.stdin.readline().strip()
estr = sys.stdin.readline().strip()

num = len(estr)
ans = ""

for i in range(num):
    ans += ostr[i] + estr[i]

if len(ostr) > num:
    ans += ostr[num]

print(ans)
