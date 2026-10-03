from collections import Counter
N = int(input())
A = list(map(int,input().split()))

counter = Counter(A)
res =[]

for word,cnt in counter.most_common():
    if 4 <= cnt:
        res.append(word)
        res.append(word)
    elif 2 <= cnt:
        res.append(word)

res = sorted(res)[::-1]
if len(res) < 2:
    print(0)
else:
    print(res[0]*res[1])
    
