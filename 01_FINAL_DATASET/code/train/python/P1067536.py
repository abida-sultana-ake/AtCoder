tmp = list(map(int, input().split()))
N = tmp[0]
A = tmp[1]
B = tmp[2]

X = list(map(int, input().split()))
distance_list = [X[i + 1] - X[i] for i in range(len(X))[:-1]]
sum = 0
for dist in distance_list:
    if A * dist > B:
        sum += B
    else:
        sum += A * dist

print(sum)