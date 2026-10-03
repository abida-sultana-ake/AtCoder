n,m = map(int,input().split())
y = 0#大人
s = 0#老人
l = 0#赤ん坊

#奇数は年寄り
if m%2:
    s+=1
    n -= 1
    m -= 3
#むり
if n*4 < m or m < n*2 or n == m == 0:
    print(-1,-1,-1)
    exit()

#さんすう
a = int(m/2)
l = a-n
y = n-l

#おかしい
if y*2 + l*4 != m or y+l != n:
    print(-1,-1,-1)
else:#ただしい
    print(y,s,l)
