n=int(input())
s=[input() for i in range(n)]
b=[]
max=0
for i in s:  
    if i not in b:
        b.append(i)

for i in range(len(b)):
     if s.count(b[i])>=max:
        max=s.count(b[i])
        max_i=i



print(b[max_i])