# -*- coding:utf-8 -*-
N, A, B = map(int, input().split())
ans = 0
for tmp in range(N):
    s, d = input().split()
    if s == 'West':
        if int(d) < A:
            ans -= A
        elif A <= int(d) and int(d) <= B:
            ans -= int(d)
        else:
            ans -= B
    else:
        if int(d) < A:
            ans += A
        elif A <= int(d) and int(d) <= B:
            ans += int(d)
        else:
            ans += B

if ans < 0:
    print('West '+str(abs(ans)))
elif ans > 0:
    print('East '+str(ans))
else:
    print(0)