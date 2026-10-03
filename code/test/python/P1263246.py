# coding: utf-8 
N,T = [int(i) for i in input().split(" ")]
array = input().split(" ")
ans = 0
fin = 0
for x in array:
    time = int(x)
    if time <= fin:
        ans += (time + T - fin)
    else:
        ans += T
    fin = time + T
print(ans)