# -*- coding:utf-8 -*-
import sys
N, M = map(int, input().split())
ans = [ 0 for tmp in range(3) ]
if M%2 != 0:
    ans[1] = 1
    N -= 1
    M -= 3
else:
    pass
for tmp in range(N+1):
    tmp2 = N-tmp
    if M-2*tmp-4*tmp2 != 0:
        continue
    else:
        ans[0] = tmp
        ans[2] = tmp2
        print(' '.join(list(map(str, ans))))
        sys.exit()
print("-1 -1 -1")