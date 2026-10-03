N,L = list(map(int,input().split()))
memo = []
for i in range(N):
    memo.append(input())
memo.sort()
for j in range(N):
    print(memo[j],end="")