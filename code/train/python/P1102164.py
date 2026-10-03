N, A, B = map(int, input().split())
l = list(map(int, input().split()))
c = l[0]
f = 0
w = B/A 
for x in l:
    d = x - c
    if w < d: f += B
    else: f += d * A
    c = x
print(f)