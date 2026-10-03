[x,y,w]=[i for i in  input().split()]
x=int(x)
y=int(y)
m={"R":[1,0],"L":[-1,0],"U":[0,-1],"D":[0,1],"RU":[1,-1],"LD":[-1,1],"LU":[-1,-1],"RD":[1,1]}
c=[]
for i in range(9):
 c.append(input())
b=c[y-1][x-1]
m1=m[w][1]
m0=m[w][0]
for i in range(3):
  if y-1+m1<0 or y-1+m1>8:
         m1*=-1
  if x-1+m0<0 or x-1+m0>8:
         m0*=-1
  x+=m0
  y+=m1
  b+=c[y-1][x-1]
  
print(b)