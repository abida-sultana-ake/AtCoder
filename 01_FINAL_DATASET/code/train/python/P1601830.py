A,B,C,D,E,F=map(int,input().split())
best_water=0
best_salt=0
best_rate=0
for i in range(30//A+1):#Aの投入数
  for j in range(30//B+1):#Bの投入数
    water=(i*A+j*B)*100
    if water<=F and water:
      max_salt=min(F-(i*A+j*B)*100,(i*A+j*B)*E)
      for k in range(max_salt//C+1):#Cを何個使うか
        l=(max_salt-C*k)//D#Dは何個つかえるか
        salt=k*C+l*D
        rate=100*salt/(water+salt)
        if rate>=best_rate and rate<=E and water+salt<=F:
          best_rate=rate
          best_salt=salt
          best_water=water
print(best_water+best_salt,best_salt)