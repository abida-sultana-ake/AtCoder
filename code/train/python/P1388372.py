# coding: utf-8

n = int(input())
ls = []
for i in range(n):
    ls.append(int(input()))
lighted = [False for i in range(n)]
inx = 1
lighted[0] = True
cnt = 0
while 1:
    dest = ls[inx - 1]
    if not lighted[dest - 1]:
        if dest == 2:
            cnt += 1
            break
        else:
            lighted[dest - 1] = True
    else:
        cnt = -1
        break
    inx = dest
    cnt += 1
    
print(cnt)

