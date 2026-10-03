import sys

def solve():
    x = input()

    ans = ord(x) - ord('A') + 1

    print(ans)

if __name__ == '__main__':
    solve()