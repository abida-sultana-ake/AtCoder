import numpy as np
S = input()
T = input()
SA = np.array([0]+[s == 'A' for s in S]).cumsum()
SB = np.array([0]+[s == 'B' for s in S]).cumsum()
TA = np.array([0]+[s == 'A' for s in T]).cumsum()
TB = np.array([0]+[s == 'B' for s in T]).cumsum()

q = int(input())
res_list = []

for _ in range(q):
    a, b, c, d = map(int, input().split())
    a_cnt = ((SA[b] - SA[a-1]) - (TA[d] - TA[c-1])) % 3
    b_cnt = ((SB[b] - SB[a-1]) - (TB[d] - TB[c-1])) % 3
    if a_cnt == b_cnt:
        res_list.append('YES')
    else:
        res_list.append('NO')
    
for i in range(q):
    print(res_list[i])