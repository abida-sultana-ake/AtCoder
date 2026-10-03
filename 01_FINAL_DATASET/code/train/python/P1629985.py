if __name__ == "__main__":
    N = int(input())
    K = int(input())
    x = list(map(int, input().split()))
    ans = 0
    for i in range(N):
        r = min(x[i],abs(K-x[i]))
        ans += 2*r
    print(ans)