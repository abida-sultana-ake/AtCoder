input()
ts = list(map(int, input().split()))
t_sum = sum(ts)
m = int(input())
for _ in range(m):
    p, x = map(int, input().split())
    print(t_sum - ts[p - 1] + x)
