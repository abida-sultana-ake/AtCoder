def main():
    """
    ball: N
    ball position: (X, Y) -> (x_i, i)
    robot A: N
    robot B: N
    A position: (X, Y) -> (0, i)
    B position: (X, Y) -> (K, i)

    A pattern: (0, a) if ball pos eq (xx, a)
    B pattern: (K, b) if ball pos eq (xx, b)
    """
    N = int(input())
    K = int(input())
    xs = map(int, input().split())

    mov_dist = 0
    for y, x in enumerate(xs, 1):
        a_dist = x
        b_dist = abs(K - x)
        dist = min(a_dist, b_dist)

        mov_dist += dist * 2

    print(mov_dist)

if __name__ == '__main__':
    main()
