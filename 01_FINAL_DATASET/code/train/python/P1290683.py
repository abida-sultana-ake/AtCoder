tmp = input().split(" ")
K = int(tmp[1])
 
num = [0 for i in range(10**5)]
for i in range(int(tmp[0])):
    tmp = input().split(" ")
    num[int(tmp[0])-1] += int(tmp[1])
    
tmp = 0
i = 0
while tmp < K:
    tmp = tmp + num[i]
    if tmp >= K:
        print(i+1)
    i = i + 1