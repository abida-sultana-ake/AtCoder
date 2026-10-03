N = int(input())
a = []
for i in range(N):
    a.append(int(input()))
yak = [0 for i in range(N)]
res = 0
for l in range(N):
    for k in range(N):
        if a[l]%a[k] == 0 and l != k:
            yak[l]+=1

for m in range(N):
    if yak[m]%2 == 0:
        res += ((yak[m])/2+1)/(yak[m]+1)
    else:
        res += ((yak[m]+1)/2)/(yak[m]+1)

print(res)    