import sys

def solve():
    O = input()
    E = input() + '#'

    ans = [c1 + c2 for c1, c2 in zip(O, E)]
    ans = ''.join(ans).rstrip('#')

    print(ans)

if __name__ == '__main__':
    solve()