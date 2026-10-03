N, K = map(int, input().split())
D = list(map(int, input().split()))

while True:
    for n_str in str(N):
        if int(n_str) in D:
            N += 1
            break
    else:
        print(N)
        break
