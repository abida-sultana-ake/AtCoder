def main():
    n, k = map(int, input().split())
    ans = k
    for i in range(1, n):
        ans *= (k - 1)
    print(ans)


if __name__ == '__main__':
    main()
