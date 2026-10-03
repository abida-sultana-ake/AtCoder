N = int(input()) 
s = [int(input()) for i in range(N)] 
s.sort()
s.reverse()
SS=0

for i in range(N):
   SS=SS+(s[i]**2)*((-1)**i)
sss=3.14159265358979*SS
print(sss)