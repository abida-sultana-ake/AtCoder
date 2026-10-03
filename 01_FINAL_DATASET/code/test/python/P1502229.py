# -*- coding:utf-8 -*-
import re
N = int(input())
w = re.split("[ \.]", input())
ans = 0
for tmp in w:
    if tmp == 'TAKAHASHIKUN' or tmp == 'Takahashikun' or tmp == 'takahashikun':
        ans += 1
    else:
        pass
print(ans)