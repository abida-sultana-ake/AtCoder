# -*- coding:utf-8 -*-
import re
S = input()
ans = re.findall(r"[A-Z]",S)
print(ans[0]+ans[2]+ans[3])