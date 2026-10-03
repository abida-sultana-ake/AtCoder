# -*- coding: utf-8 -*-
import sys
import io

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

n, m = map(int, input().split())
n_list = [input().split()[0] for _ in range(n)]
m_list = [input().split()[0] for _ in range(m)]
dif = n-m

ans = ""

class DropNest(Exception):
    pass 

try:
    for i in range(dif+1):
        for j in range(dif+1):
            target = n_list[i][j:j+m]
           
            if target != m_list[0]:
                continue
            else:
                cnt = 0
                for k in range(m):
                    target_h = n_list[i+k][j:j+m]
                    if target_h == m_list[k]:
                        cnt+=1
                if cnt==m:
                    ans="Yes"
                    raise DropNest
    print("No")
except DropNest:
    print(ans)


