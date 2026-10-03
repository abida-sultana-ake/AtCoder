n=int(input())
arr=["a","b","c"]
newArr=["a","b","c"]
i=1
if n==1:
    ansArr=arr
else:
    while i<n:
        ansArr=[]
        for x in newArr:
            for y in arr:
                ansArr.append(x+y)
        newArr=ansArr
        i+=1
for z in ansArr:
    print(z)
