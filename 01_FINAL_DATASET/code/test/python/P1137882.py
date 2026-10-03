n=int(input())
l=[0]*4
for i in range(n):l[i]=int(input())
l.sort()
print(min(max(l[0]+l[1]+l[2],l[3]),max(l[0]+l[3],l[1]+l[2])))