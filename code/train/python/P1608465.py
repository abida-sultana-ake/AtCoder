import math
a,b=(int(i) for i in input().split()) 
s=[int(i) for i in input().split()] 
n=[0,1,2,3,4,5,6,7,8,9]
n1 = [val for val in n if val not in s]
n1.sort()
keta=int(math.log10(a) + 1)
n_number=10-b
aa=str(a)
answer=[]
OKANE1=0
OKANE2=0
OKANE3=0
OKANE4=0
OKANE5=0

for i in range(n_number+1):
  for j in range(n_number+1):
    for k in range(n_number+1):
      for l in range(n_number+1):
        for m in range(n_number):
          if i!=0: 
            OKANE1=n1[i-1]
          if j!=0:          
            OKANE2=n1[j-1]
          if k!=0:           
            OKANE3=n1[k-1]
          if l!=0:           
            OKANE4=n1[l-1]
            
          OKANE5=n1[m]
          OKANE=10000*OKANE1+1000*OKANE2+100*OKANE3+10*OKANE4+OKANE5  
          if a<=OKANE:
            answer.append(OKANE)
print(min(answer))

