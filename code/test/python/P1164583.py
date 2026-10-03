N,a=map(int,input().split())
a -= 1
k=int(input())
b=list(map(lambda s:int(s)-1,input().split()))
c=[-1]*len(b)

t = 0
while True:
  if c[a] != -1:
    cycleLen = t - c[a]
    k = k % cycleLen
  if k == 0:
    print(a+1)
    break
  c[a] = t
  a = b[a]
  t += 1
  k -= 1
