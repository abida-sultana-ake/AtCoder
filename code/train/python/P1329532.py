import math


def rren(): return list(map(int, input().split()))


N, A, B = rren()
h = []
for i in range(N):
    h.append(int(input()))


left = 0
right = math.ceil(max(h)/B)
while(left <= right):
    K = math.floor((left + right) / 2)
    if(left == right):
        print(K)
        break
    else:
        sum = 0
        for i in range(N):
            sum += max(0, math.ceil((h[i] - K*B)/(A-B)))
        if(sum <= K):
            right = K
        else:
            left = K+1

