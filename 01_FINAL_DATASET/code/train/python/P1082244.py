import sys
from collections import Counter

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG: {} -> {}'.format(name, val), file=sys.stderr)
            return None

N = int(input())
cnt_A = Counter(map(int, input().split()))

# debug(cnt_A, locals())
# debug(cnt_A.values(), locals())

dabuli = sum(cnt_A.values()) - len(cnt_A.values())

if dabuli % 2 == 0:
    ans = N - dabuli
else:
    ans = N - (dabuli + 1)

print(ans)