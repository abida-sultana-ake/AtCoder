
x = list(map(int, input().split()))
a=[input() for i in range(x[1])]
count=[]

for i in range(0,x[0]+2):
    count=count+[[0,i]]

for i in a:
    i=list(map(int, i.split()))
    count[i[0]][0]+=1
    count[i[1]][0]+=1
   
  
for i in range (1,x[0]+1):
    print(count[i][0])
