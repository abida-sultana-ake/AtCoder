N = int(input())
T = list(map(int, input().split(" ")))

M = int(input())
X = []
for _ in range(M):
    x_list = list(map(int, input().split(" ")))
    X.append(x_list)

T_sum = sum(T)
for (i, x) in X:
    i -= 1
    diff = T[i] - x
    print(T_sum - diff)
