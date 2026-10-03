#003
N,x= [int(i) for i in input().split(" ")]
list = [int(i) for i in input().split(" ")]
count = 0 
for i in range(N):
    if(i==0):
        if list[i]>x:
            temp = list[i]-x
            count+=temp
            list[i]-=temp
    else:
        temp = list[i]+list[i-1]-x
        if(temp>0):
            count+=temp
            list[i]-=temp    
print(count)