N, K = map(int, input().split())
D = set(map(int, input().split()))
i = N
while True:
    j = i
    flag = True
    while j > 0:
        r = j % 10
        if r in D:
            flag = False
            break
        j //= 10
    if flag:
        print(i)
        break
    i += 1
