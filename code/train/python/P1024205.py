#003
N,x=input().split(" ")
s = input().split(" ")
list = []
for i in range(int(N)):
    list.append(int(s[i]))
count = 0

if(list[0]>int(x)):
    count+=list[0]-int(x)
    list[0]-=list[0]-int(x)

for i in range(1,int(N)):
    temp = list[i]+list[i-1]
    if(temp>int(x)):
        count+=temp-int(x)
        list[i]-=temp-int(x)        
print(count) 