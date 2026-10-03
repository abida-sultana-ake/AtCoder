# -*- coding:utf-8 -*-
import sys
S = input()
ans = []
for tmp in ['A','B','C','D','E','F']:
    ans.append(S.count(tmp))
for tmp in range(len(ans)):
    if tmp < len(ans)-1:
        sys.stdout.write(str(ans[tmp])+' ')
    else:
        print(str(ans[tmp]))