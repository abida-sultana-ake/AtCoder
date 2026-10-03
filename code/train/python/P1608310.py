s = input().split()
b=[]

for i in range(3):
  free2=3-i
  for j in range(free2):
    free3=3-i-j
    for k in range(free3):
       b.append(int(s[i])+int(s[i+j+1])+int(s[i+j+k+2]))
#       print(i,i+j+1,i+j+k+2)
b2 = list(set(b))  
b2.sort()
b2.reverse()
print(b2[2])