# coding: utf-8
n = int(input())
data = list(map(int,input().split()))
dic = {}
max1=0
max2=0
for x in data:
    if x not in dic:
        dic[x]=1
    else:
        dic[x]+=1
    if dic[x]>=2:
        if max1<x:
            max2=max1
            max1=x
            dic[x]=0
        elif max2<x:
            max2=x
            dic[x]=0
        else:
            pass
print(max1*max2)