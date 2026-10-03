def decrease(A,N):
    t = 0
    while(1):
        if max(A) <= N -1: break
        else:
            for i in range(N): A[i] = A[i] + 1
            i = A.index(max(A))
            A[i] = A[i] - N - 1
            t += 1
    return t


if __name__ == '__main__':
    K = int(input())
    p,q = K // 50, K % 50
    A = [i for i in range(50)]
    N = 50
    A = [a + p for a in A]
    for i in range(q):
        A = [a - 1 for a in A]
        A[i] += N + 1

    print(len(A))
    A = [str(a) for a in A]
    print(" ".join(A))