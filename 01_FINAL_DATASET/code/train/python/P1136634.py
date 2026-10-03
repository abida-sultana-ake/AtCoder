import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    S = input().upper()
    p = 'ICT'

    if ex_subs(S, p):
        ans = 'YES'
    else:
        ans = 'NO'

    print(ans)

def ex_subs(S, p):
    cnt = 0
    k = 0

    for c in p:
        for i in range(k, len(S)):
            if c == S[i]:
                k = i + 1
                cnt += 1

                if cnt == len(p):
                    return True

                break

    return False

if __name__ == '__main__':
    solve()