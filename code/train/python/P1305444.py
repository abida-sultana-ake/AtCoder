# -*- coding:utf-8 -*-
import sys
N = int(input())
NG = [ int(input()) for tmp in range(3) ]
ans = [ float('inf') for tmp in range(N+1) ]
ans[N] = 0
if N in NG:
    print("NO")
    sys.exit()
else:
    #木の探索は分岐数的に無理。3^100回になる。探索不可。
    #DP?
    for tmp in reversed([ i for i in range(N+1) ]):
        if tmp in NG:
            continue
        for tmp2 in range(1,4):
            if tmp-tmp2 >= 0:
                ans[tmp-tmp2] = min(ans[tmp]+1, ans[tmp-tmp2])
            else:
                pass
    if ans[0] <= 100:
        print("YES")
    else:
        print("NO")