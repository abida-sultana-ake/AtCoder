[n,l]=[int(i) for i in input().split()]
c=[]
for i in range(l):
  c.append(list(input()))
a=input().find("o")
for i in reversed(range(l)):
   d=a
   if a-1>=0 and c[i][a-1]=="-":
        d-=2
   if a+1<n*2-1 and c[i][a+1]=="-":
        d+=2
   a=d
print(int(a/2)+1)