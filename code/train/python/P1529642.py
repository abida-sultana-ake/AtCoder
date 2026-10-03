n = int(input())
s1 = input() + " "
s2 = input() + " "
 
mod = 1000000007
 
num = 1
i = 0
b = 0
tmp_t = -1
while(b + i < n):
    if s1[i + b] == s2[i + b]: # t 0
        if tmp_t == 0:
            num = (num * 2) % mod
        elif tmp_t == 1:
            num = (num * 1) % mod
        else:
            num = 3
        tmp_t = 0
    else: # t 1
        if tmp_t == 0:
            num = (num * 2) % mod
        elif tmp_t == 1:
            num = (num * 3) % mod
        else:
            num = 6
        tmp_t = 1
        b += 1
    i += 1
 
print(num)