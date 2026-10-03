N=int(input())
s=[]
sum=0
for i in range(N):
    s.append(int(input()))
    sum+=s[i]

#print("sum="+str(sum))

min=100000000

if sum%10==0:
    for i in range(N):
        if(min>=s[i] and s[i]%10!=0):
            min=s[i]
#            print("err")
if sum%10!=0:
    print(sum)
elif min!=100000000:
    print(sum-min)
else:
    print(0)