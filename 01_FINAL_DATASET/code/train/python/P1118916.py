def solve(s, c):
    """rv = min(Sr, Cr//2), where
       Sr = S + a
       Cr = C - 2a  # a>=0, a is number of (2c->S) conversions
       thus
       rv = max(min(S + a, C//2 - a) for a in range(0, C//2))
       if a >=0, optimum is Sr == Cr//2, thus
                            S + a == Cr//2 - a
                            a = (C//2 - S) / 2
    """
    a = (c / 2 - s) / 2
    if a < 0:
        a = 0
    al = int(a)
    ar = int(a) + 1
    return max(min(s + a, c//2 - a) for a in (al, ar))


if __name__ == "__main__":
    import sys
    S, C = map(int, sys.stdin.readline().split())
    print(solve(S, C))


def test_solve():
    assert solve(1, 2) == 1
    assert solve(0, 4) == 1
    assert solve(0, 1) == 0


def test_atcode():
    assert solve(1, 6) == 2
    assert solve(12345, 678901) == 175897