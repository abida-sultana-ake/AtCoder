from collections import Counter
N = list(map(int,input().split()))
c = Counter(N)


for k,v in c.items():
     if v == 1:
          print(k)
