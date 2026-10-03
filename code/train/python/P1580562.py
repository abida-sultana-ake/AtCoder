import sys

written = set()

N = int(sys.stdin.readline())

for i in range(N):
    tmp = int(sys.stdin.readline())
    if tmp in written:
        written.remove(tmp)
    else:
        written.add(tmp)
print(len(written))