if __name__ == '__main__':
    N = int(input())
    p = list(map(int, input().split()))

    counter = 0
    if p[0] == 1:
        counter += 1
        p[0], p[1] = p[1], p[0]

    # print(p)
    for i in range(1, N - 1):
        if p[i] == i + 1:
            counter += 1
            if p[i - 1] != i and p[i + 1] != i + 2:
                p[i - 1], p[i] = p[i], p[i - 1]
            else:
                p[i], p[i + 1] = p[i + 1], p[i]
    if p[N - 1] == N:
        counter += 1

    print(counter)
