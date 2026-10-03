def solve(votes):
    for start in [(1, 1), (1, 0), (0, 1), (0, 0)]:
        a = animals(start, votes)
        if a[:2] == a[-2:]:
            return a


def animals(start, votes):
    rv = [None] * len(votes)
    rv[:2] = start
    for i in range(1, len(votes) - 1):
        rv[i + 1] = rv[i - 1] ^ rv[i] ^ votes[i]
    return tuple(rv)


def parse(s):
    return tuple(int(v == "o") for v in s + s[:2])


def display(s):
    if not s:
        return "-1"
    return "".join("S" if v else "W" for v in s[:-2])


if __name__ == "__main__":
    import sys
    _n = sys.stdin.readline()
    votes = sys.stdin.readline().strip()
    votes = parse(votes)
    sol = solve(votes)
    print(display(sol))


def test_parse():
    assert parse("ooxoox") == (1, 1, 0, 1, 1, 0, 1, 1)


def test_display():
    assert display((1, 1, 0, 0, 7, 7)) == "SSWW"


def test_animals():
    p = object()  # sentinel or poison
    assert animals((1, 1), (p, 1, p)) == (1, 1, 1)
    assert animals((1, 1), (p, 0, p)) == (1, 1, 0)
    assert animals((0, 1), (p, 1, p)) == (0, 1, 0)
    assert animals((1, 0), (p, 1, p)) == (1, 0, 0)


def test_animals_lex():
    assert animals((1, 1), parse("ooo")) == (1, 1, 1, 1, 1)
    assert animals((1, 1), parse("xxx")) == (1, 1, 0, 1, 1)


def test_solve_atcoder():
    assert display(solve(parse("oox"))) == "-1"
    assert display(solve(parse("ooxoox"))) == "SSSWWS"
    assert display(solve(parse("oxooxoxoox"))) == "SSWWSSSWWS"