N = int(input())
a_array = [int(i) for i in input().split()]
dic = {i: 0 for i in range(-1, 10**5+1)}

for a in a_array:
    dic[a] += 1
    dic[a-1] += 1
    dic[a+1] += 1
max_v = 0
for k, v in dic.items():
    if v > max_v:
        max_v = v

print(max_v)
