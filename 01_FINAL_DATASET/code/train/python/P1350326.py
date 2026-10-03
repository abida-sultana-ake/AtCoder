N = int(input())
a = list(map(int,input().split()))
c = []
d = []
for j in range(N):
  for i in range(0,8):
    if 400*(i) <= a[j] < 400*(i+1):
       if i not in c:
           c.append(i)
  if a[j] >= 3200:
        d.append(a[j])
if len(c) ==0:
    print(1,len(d))
else:
    print(len(c),len(c)+len(d))