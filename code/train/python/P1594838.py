N, K = map(int, input().split())
D = set(input().split())
for i in range(N, 10**9):
    if not set(str(i)) & D:
        print(i)
        break