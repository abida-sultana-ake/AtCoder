import sys

stdin = sys.stdin
def na(): return map(int, stdin.readline().split())
def ns(): return stdin.readline().strip()

n,m = na()
ba = []
for i in range(n):
    ba.append(ns())
bb = []
for i in range(m):
    bb.append(ns())

for i in range(n-m+1):
    for j in range(n-m+1):
        ok = True
        for k in range(m):
            if ba[i+k][j:j+m] != bb[k]:
                ok = False
                break
        if ok:
            print("Yes")
            sys.exit(0)
print("No")
