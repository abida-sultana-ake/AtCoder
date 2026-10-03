import sys

cin = sys.stdin

N, T = map(int, cin.readline().split())
t = list(map(int, cin.readline().split()))

cnt = 0
for i in range(1,N):
    cnt += min(t[i]-t[i-1], T)
cnt += T
    
print(cnt)
