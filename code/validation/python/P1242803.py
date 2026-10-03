import sys

def solve():
    N = int(input())
    A = [int(i) for i in input().split()]

    cnt = sum(ai > 0 for ai in A)
    bug = sum(A)

    ans = (bug + cnt - 1) // cnt

    print(ans)

if __name__ == '__main__':
    solve()