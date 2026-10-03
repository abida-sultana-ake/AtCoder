
line1=input().split()
n=int(line1[0])
a=int(line1[1])
nums=input().split()
for i in range(n):
    nums[i]=int(nums[i])-a

works={}

works[0]=1
s=0
for x in nums:

    if x>=0:
        for i in range(50*(n+1),-50*(n+1), -1):
            try:
                works[i]+=works[i-x]
            except:
                try:
                    works[i]=works[i-x]
                except:
                    pass
    else:
        for i in range (-50*(n+1),50*(n+1)):
            try:
                works[i+x]+=works[i]
            except:
                try:
                    works[i+x]=works[i]
                except:
                    pass

print (works[0]-1)
