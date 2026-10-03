import sys

mod = 10**9 + 7

def solve():
    n, m = map(int, input().split())
    x = [int(i) for i in input().split()]
    y = [int(i) for i in input().split()]

    ans = calc_all_section_length_sum(x)
    ans = (ans * calc_all_section_length_sum(y)) % mod

    print(ans)

def calc_all_section_length_sum(a):
    n = len(a)
    res = 0

    for i, ai in enumerate(a):
        res += (ai * (2*i + 1 - n)) % mod
        res %= mod

    return res

if __name__ == '__main__':
    solve()