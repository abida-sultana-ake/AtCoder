import collections
n = int(input())
a = list(map(int,input().split()))
aa = []
sq = []
l = collections.Counter(a)
for k,v in l.items():
    if v >= 4:
        sq.append(k)
    if v >= 2:
        aa.append(k)

aa.sort()
sq.sort()
if sq and len(aa)>=2:
    print(max(sq[-1]**2, aa[-1]*aa[-2]))
elif len(aa)>=2:
    print(aa[-1]*aa[-2])
elif sq:
    print(sq[-1]**2)
else:
    print("0")

