def main():
    N, M = map(int, input().split())
    A = []
    for i in range(N):
        A.append(input())
    B = []
    for i in range(M):
        B.append(input())
    for i in range(N - M + 1):
        for j in range(N - M + 1):
            if check(i, j, M, A, B):
                print('Yes')
                return
    print('No')


def check(i, j, M, A, B):
    for w in range(M):
        for h in range(M):
            if A[i + w][j + h] != B[w][h]:
                return False
    return True

if __name__ == '__main__':
    main()
