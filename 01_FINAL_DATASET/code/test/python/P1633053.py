L, H = map(int, input().split())
N = int(input())
for _ in range(N):
    a = int(input())
    print(max(0, L - a) if a <= H else -1)
