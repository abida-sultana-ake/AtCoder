N = int(input())
a = list(map(int, input().split()))

c = [0,0,0,0]
for x in a:
    c[x % 4] += 1

if (c[1]==0) and (c[3]==0):
    print('Yes')
elif c[1] + c[3] < c[0] + 1:
    print('Yes')
elif (c[1] + c[3] == c[0] + 1)and(c[2] == 0):
    print('Yes')
else:
    print('No')