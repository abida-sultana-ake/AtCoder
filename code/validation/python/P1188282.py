N=int(input())
command=list(input())

dic={}
for i in range(len(command)):
    if i!= len(command)-1:
        s = command[i]+command[i+1]
        if s in dic:dic[s]+=1
        else: dic[s]=1
            
min_length=len(command)
for key1 in dic:
    for key2 in dic:
        tmp=''.join(command).replace(key1,'L').replace(key2,'R')
        if len(tmp)<min_length:min_length=len(tmp)

print(min_length)