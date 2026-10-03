import math
N = int(input())
N2 = int(math.sqrt(N))
# 正方形だった場合
result = N-N2*N2

# N2+1とN2の長方形
d=1
while True:
    if N2*(N2+d) > N:
        break
    result = min(result, N-(N2*(N2+d))+d)
    d+=1


# N2*N2の正方形から片方の辺を１ずつ短くしていく
for i in range(N2-1, 0, -1):
    j = i
    # 短くした辺と別の辺を伸ばしていく
    while True:
        if i*j > N:
            break
        result = min(N-(i*j)+abs(i-j), result)
        j+=1
print(result)