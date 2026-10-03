import bisect
n=input()
wh1=[]
for i in xrange(n):
    wh1.append(map(int,raw_input().split()))
    wh1[-1][1]=wh1[-1][1]*(-1)
wh1.sort()
wh=[]
for i in xrange(n):
    wh.append([wh1[i][0],wh1[i][1]*(-1)])
dp=[float("inf")]*n
for i in xrange(n):
    dp[bisect.bisect_left(dp,wh[i][1])]=wh[i][1]
for i in xrange(n):
    if dp[i]==float('inf'):
        i-=1
        break
print(i+1)