N = int(input())
S = input()
C = [
'AA','AB','AX','AY','BA','BB','BX','BY',
'XA','XB','XX','XY','YA','YB','YX','YY',]

def calc(lc,rc):
    i = ret = 0
    while i < N:
        ret += 1
        if i == N-1:
            break
        if S[i:i+2] == lc or S[i:i+2] == rc:
            i += 2
        else:
            i += 1
    return ret

ans = N
for l in range(15):
    for r in range(l+1,16):
        ans = min(ans, calc(C[l],C[r]))
print(ans)
