N = int(input())
T = list(map(int, input().split()))
s = sum(T)
for i in range(int(input())):
    p, x = list(map(int, input().split()))
    v = -(T[p - 1] - x)
    print(s + v)
