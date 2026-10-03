n = int(input())

def query(command, a, b):
    print('{0} {1} {2}'.format(command, a, b), flush=True)

maxv = 0
maxi = 0
for i in range(n-1):
    query('?', 1, 2+i)
    a = int(input())
    if a > maxv:
        maxv = a
        maxi = 2+i

for i in range(n-1):
    if i == maxi:
        continue
    query('?', maxi, 2+i)
    a = int(input())
    if a > maxv:
        maxv = a

print('! {0}'.format(maxv))
