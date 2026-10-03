def solution(N, K, A):
    # demoテストのように累積和をとっておく
    accum = [0] * (N + 1)
    for i in range(N):
        accum[i+1] = accum[i] + A[i]

    ans = 0
    for i in range(N):
        if i + K > N:
            break
        ans += accum[i+K] - accum[i]
    return ans


if __name__ == '__main__':
    N, K = map(int, input().split())
    A = [int(x) for x in input().split()]
    print(solution(N, K, A))
