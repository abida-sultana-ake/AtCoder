# -*- coding:utf-8 -*-
import math
N = int(input())
C = [ int(input()) for tmp in range(N) ]
ans = 0
for tmp in range(N):
    factor= 0
    for tmp2 in range(N):
        if tmp != tmp2 and C[tmp]%C[tmp2] == 0:
            factor += 1 #対象コインに対して、何個のコインが裏返し要員になるか。
        else:
            pass
    #裏返し要員のコインfactor枚と対象のコインで1枚、計(factor+1)の並び方は(factor+1)!通り存在。
    #裏返し要員のコインfactor枚中、裏返し要員コインq枚がくるのはfactor_C_q通り。
    #そして対象コインの左側q枚の組み合わせはq!通り。対象コイン右側の組み合わせは(factor-q)!通り。
    let1 = math.factorial(factor)
    let2 = let1*(factor+1)
    for tmp3 in range(0, factor+1, 2):
        #let3 = math.factorial(factor-tmp3)
        #let4 = math.factorial(tmp3)
        #ans += ((let1/(let3*let4)) * let3 * let4) / let2
        ans += let1 / let2
print(ans)