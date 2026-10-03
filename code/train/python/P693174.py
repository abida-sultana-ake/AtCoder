# -*- coding: utf-8 -*-

S = input()
T = int(input())
state = [0, 0]

num_unknown = S.count('?')

for s in S.replace('?', ''):
    if s == 'L':
        state[0] -= 1
    elif s == 'R':
        state[0] += 1
    elif s == 'U':
        state[1] += 1
    elif s == 'D':
        state[1] -= 1


if T == 1:
    print(sum(abs(p) for p in state) + num_unknown)
elif T == 2:
    ans = sum(abs(p) for p in state) - num_unknown

    if ans < 0:
        if ans % 2 == 0:
            print(0)
        else:
            print(1)

    else:
        print(ans)
