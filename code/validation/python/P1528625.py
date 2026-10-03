def main():
    """
    2 * N, square
    N domino
    domino, 2 * 1 or 1 * 2

    [pattern 1]
    aabb
    ccdd
    (a, d) and (b, c) => 2 colors
    (a, d) and c and b => 3 colors
    (c, b) and a and d => 3 colors

    [pattern 2]
    aab
    ccb
    => 3 colors

    [pattern 3]
    abc
    abc
    2 or 3 colors

    このような塗り方が何通りあるかを
    mod 1000000007 で求めてください．
    """
    N = int(input())
    S1 = input()
    S2 = input()

    a = 1
    before = "f"
    # f irst
    # v ertical
    # h orizontal
    i = 0
    while i < N:
        if S1[i] == S2[i]:
            # v
            if before == "f":
                a *= 3
            elif before == "v":
                a *= 2
            else:
                pass
            before = "v"
            i += 1
        else:
            # h
            if before == "f":
                # 3 P 2
                a *= 6
            elif before == "v":
                a *= 2
            else:
                a *= 3
            before = "h"
            i += 2

    print(a % 1000000007)

if __name__ == '__main__':
    main()
