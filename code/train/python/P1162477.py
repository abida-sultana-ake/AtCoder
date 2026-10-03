N,M=map(int,input().split())
X,Y=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
i=0
j=0
t=0
ans=0
while True:
  while i < len(a) and a[i] < t: i += 1
  if i == len(a): break
  t = a[i] + X
  while j < len(b) and b[j] < t: j += 1
  if j == len(b): break
  t = b[j] + Y
  ans += 1
print(ans)
