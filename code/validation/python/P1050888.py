import sys

cin = sys.stdin
#cin = open("in.txt", "r")

MODULO = int(10**9+7)
N = int(cin.readline())
A = list(map(int, cin.readline().split()))
pos = [0]*(N+1)
if (N%2==1):
    pos[0]=1
for ai in A:
    if (ai+N)%2==0 or ai>=N or ai<0:
        print(0)
        exit()
    pos[ai]+=1
    if pos[ai]>2:
        print(0)
        exit()
cnt = 1
for i in range(N//2):
    cnt = cnt * 2 % MODULO
print(cnt)