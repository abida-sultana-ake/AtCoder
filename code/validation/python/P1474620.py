if __name__ == '__main__':
    N, M = list(map(int, input().split()))
    a = []
    b = []
    for i in range(M):
        tmp_a, tmp_b = list(map(int, input().split()))
        a.append(tmp_a)
        b.append(tmp_b)

    c = set([b[i] for i in range(0, M) if a[i] == 1])

    for i in range(0, M):
        if a[i] in c and b[i] == N:
            print("POSSIBLE")
            break
    else:
        print("IMPOSSIBLE")
