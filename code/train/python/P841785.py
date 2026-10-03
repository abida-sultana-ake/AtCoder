def sqsum(a, x):
    s = 0
    for i in range(len(a)):
        s += (a[i]-x)**2
    return s
    
n = int(input())
a = [int(i) for i in input().strip().split()]
s = sum(a)
sq = []
for x in range(-100, 101):
    sq.append(sqsum(a, x))
print(min(sq))    