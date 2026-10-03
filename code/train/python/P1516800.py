# coding: utf-8
n,r=map(int,input().split())
s = [0 if i=='.' else 1 for i in input() ]
ans = 0
now = 0
count = n-sum(s)
shot = [1 for i in range(r)]
move = (n-s[::-1].index(0))-r if s.count(0) and (n-s[::-1].index(0))-r > 0 else 0
while count:
    s[s.index(0):s.index(0)+r]=shot
    ans+=1
    count = s.count(0)
print(ans+move)