n=int(input())
arr=[]
for i in range(n):
    a,b=map(int,input().split("-"))
    a=a-a%5
    a=a//100*60+a%100
    if b%5!=0:
        b=b+5-b%5
    b=b//100*60+b%100       
    arr.append([a,b])
a=[0]*(60*24+1) #1441
for i in range(n):
    a[arr[i][0]]+=1
    a[arr[i][1]]-=1
for i in range(1440):
    a[i+1]+=a[i]
s=0
g=0
i=0
j=0

while i <= 1440:
    if a[i]>=1:
        s="{:04d}".format(i//60*100+i%60)
        j=i+6
        while j <1441:
            if a[j]==0:
                g="{:04d}".format((j-1)//60*100+(j-1)%60)
                print(str(s)+"-"+str(g))
                i=j+4
                break
            else:
                j+=5
        else:
            print(str(s)+"-2400")
            i=99999
            break
    else:
        i+=5


