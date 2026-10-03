if __name__ == "__main__":
    N = int(input())
    T = list(map(int, input().split()))
    M = int(input())
    data = []
    for x in range(M):
        p,x = map(int, input().split())
        p -= 1
        data.append([p, x])
    result = 2 ** 60
    for p,x in data:
        res = 0
        for i,t in enumerate(T):
            if (i == p):
                res += x
            else:
                res += t
        print (res)
