import sys
stdin = sys.stdin
def na(): return map(int, stdin.readline().split())
def ns(): return stdin.readline().strip()

s = ns()
t = int(stdin.readline())
print(s[t-1])
