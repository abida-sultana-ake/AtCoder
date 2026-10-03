C = int(input())
opt = [0,0,0]
for i in range(C):
    src = list(map(int,input().split()))
    src.sort()
    for j in range(3):
        opt[j] = max(opt[j], src[j])
print(opt[0] * opt[1] * opt[2])
