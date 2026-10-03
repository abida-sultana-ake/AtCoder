N = int(input())
K = int(input())
x = list(map(int,input().split()))
kyori = 0
for i in range(N):
    kyori += min(x[i]*2,abs(K-x[i])*2)
print(kyori)