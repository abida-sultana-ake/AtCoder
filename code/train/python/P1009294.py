#C
N, x = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]

over = a[0]-x
if over < 0:
    over = 0
eat, a[0] = over, a[0]-over
for i in range(N-1):
    over = a[i]+a[i+1]-x
    if over < 0:
        over = 0
    eat, a[i+1] = eat + over, a[i+1]-over
print(eat)