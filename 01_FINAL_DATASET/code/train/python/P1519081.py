N, A, B = map(int, input().split())

li = [int(input()) for i in range(N)]

if (max(li) - min(li)) != 0:
    num = B / (max(li) - min(li))
    ans = ((sum(li) * num) - (A * N)) * -1 / N
    print(num, end=" ")
    print(ans)
else:
    num = -1
    print(num)
