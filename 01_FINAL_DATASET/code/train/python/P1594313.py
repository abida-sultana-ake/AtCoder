# 解説・他の方の回答を見た
N, M = map(int, input().split())

for a in range(N+1):
    for b in range(2):
        c = N - a - b
        if M == 2*a + 3*b + 4*c and c >= 0:
            f = True            
            break
        else:
            f = False
    if f:
        break
        
if f:
    print(a, b, c)
else:
    print(-1, -1, -1)