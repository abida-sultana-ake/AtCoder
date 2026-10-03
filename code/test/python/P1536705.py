N=int(input())
s=set()
ans=0
for i in range(N):
  fl=int(input())
  if fl in s: ans+=1
  s.add(fl)
print(ans)