def t(s, e, l, sp):
    d = e - s
    if d < 0:
        d += l
    return d / sp


def main():
    L, X, Y, S, D = map(int, input().split())
    ans = t(S, D, L, X + Y)
    if Y > X:
        ans = min(ans, t(D, S, L, Y - X))
    print(ans)

if __name__ == '__main__':
    main()
