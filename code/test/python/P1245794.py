import sys

def solve():
    n = int(input())
    ans = min(int(input()) for i in range(n))
    print(ans)

if __name__ == '__main__':
    solve()