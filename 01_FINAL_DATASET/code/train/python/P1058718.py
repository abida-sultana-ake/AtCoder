k,s = map(int,input().split())
ans = 0
for x in range(0,k+1):
  for y in range(0,k+1):
    if s-x-y<=k and s-x-y>=0:
      ans+=1

print(ans)