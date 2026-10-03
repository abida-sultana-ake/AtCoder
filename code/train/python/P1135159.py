import sys

def debug(x, table):
    for name, val in table.items():
        if x is val:
            print('DEBUG:{} -> {}'.format(name, val), file=sys.stderr)
            return None

def solve():
    S = input()
    cnt = 0

    for i in range(len(S)):
        if i == 0:
            continue
        if S[i] != S[i - 1]:
            cnt += 1

    print(cnt)

if __name__ == '__main__':
    solve()