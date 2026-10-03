
N,M = map(int, input().split())
count = [0 for i in range(N+1)] #0-N番の道路の個数（０番目は使用しないように注意)

for i in range(M):
    a,b = map(int, input().split())
    count[a]+=1
    count[b]+=1

for i in range(1,N+1):
    print(count[i])
    