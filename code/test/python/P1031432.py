N = int(input())
T = list(map(int,input().split()))
M =int(input())

sumT = sum(T)

for _ in range(M):
    p,x = map(int,input().split())
    ans = sumT -T[p-1]+x
    print(ans)
