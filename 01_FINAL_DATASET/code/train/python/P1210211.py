NONE_RES,A_RES,B_RES = 0,1,2
buf = [[NONE_RES,B_RES,A_RES],[A_RES,NONE_RES,B_RES],[B_RES,A_RES,NONE_RES]]

S = input()
s = [1 if c == 'A' else 0 for c in S]
T = input()
t = [1 if c == 'A' else 0 for c in T]
n = int(input())

sum_s = [0]
for s_ in s:
    sum_s.append(sum_s[-1]+s_)

sum_t = [0]
for t_ in t:
    sum_t.append(sum_t[-1]+t_)

for _ in range(n):
    a,b,c,d = map(int,input().split(' '))
    A1 = sum_s[b] - sum_s[a-1]
    B1 = (b-(a-1))-A1
    A2 = sum_t[d] - sum_t[c-1]
    B2 = (d-(c-1))-A2
    type1 = buf[A1%3][B1%3]
    type2 = buf[A2%3][B2%3]
    if type1==type2:
        print('YES')
    else:
        print('NO')