if __name__ == '__main__':
    N,M = map(int, input().split())
    if(M<=2*N):
        ans = M // 2
        print(ans)
    else:
        ans = N + (M-2*N)//4
        print(ans)
