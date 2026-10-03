def main():
    # 1 to N => 1 to X to N
    N, M = map(int, input().split())
    from1 = set()
    toN = set()
    for i in range(M):
        a, b = map(int, input().split())
        if a == 1:
            from1.add(b)
        if b == N:
            toN.add(a)

    if from1 & toN:
        print("POSSIBLE")
    else:
        print("IMPOSSIBLE")

if __name__ == '__main__':
    main()
