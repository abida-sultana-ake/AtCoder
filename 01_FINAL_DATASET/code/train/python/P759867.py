def sigma(n):
    s = 0
    for i in range(1,n+1):
        s += i
    return s

N = int(input())

a = list(map(int,input().split()))
a.append(0)
dif =  []

count = 0
pre_sum = 0
for i in range(N):
    if a[i] < a[i+1]:
        count += 1
    else:
        pre_sum += sigma(count+1)
        count = 0
            
print(pre_sum)


