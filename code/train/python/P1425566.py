def main():
    N, K = list(map(int, input().strip().split()))
    ls = list(map(int, input().strip().split()))
    k_total = sum(sorted(ls, reverse=True)[:K])
    print(k_total)

if __name__ == '__main__':
    main()
