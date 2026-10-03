import math

n = int(input())
ans_max = float(0)
x1,y1 = [],[]

for i in range(n):
    string_name = input()
    int_name = string_name.split(' ')
    x1.append(float(int_name[0]))
    y1.append(float(int_name[1]))

for i in range(n):
    for j in range(i+1,n):
        tmp = abs(x1[i]-x1[j])
        tmp2 = abs(y1[i]-y1[j])
        length = math.sqrt(math.pow(tmp,2) + math.pow(tmp2,2))
        ans_max = max(ans_max,length)

print(ans_max)