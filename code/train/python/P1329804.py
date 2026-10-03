import sys

def solve():
    n = int(input())
    s = [int(input()) for i in range(n)]
    s.sort()

    ssum = sum(s)

    if ssum % 10:
        print(ssum)
    else:
        for si in s:
            if si % 10:
                print(ssum - si)
                return

        print(0)

if __name__ == '__main__':
    solve()