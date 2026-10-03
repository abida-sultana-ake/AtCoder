def detect(n,c):
    if n%2 and c.pop(0) != 1:
        return False
    for i in range(1,n,2):
        if c[i] != 2:
            return False
    else:
        return True

N = int(input())

count = [0 for x in range(N)]
for x in map(int,input().split()):
    count[x] += 1

if detect(N,count):
    print((2**(N>>1)) % 1000000007)
else:
    print(0)