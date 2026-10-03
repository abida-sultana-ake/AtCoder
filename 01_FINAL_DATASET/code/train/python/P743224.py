import sys


stdin = sys.stdin

n = int(stdin.readline().strip())
a=list(map(int, stdin.readline().split()))

pre = -100000
le = 0
ret = 0
for x in a:
    if x > pre:
        le += 1
    else:
        le = 1
    ret += le
    pre = x
print(ret)
