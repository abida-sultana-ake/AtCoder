import sys

stdin = sys.stdin


def na(): return map(int, stdin.readline().split())


def ns(): return stdin.readline().strip()


stack = []
n,k = na()
for i in range(n):
    stack.append(list(na()))
stack.sort(key=lambda x: x[0])

sp = 0
for x in stack:
    sp += x[1]
    if sp >= k:
        print(x[0])
        break