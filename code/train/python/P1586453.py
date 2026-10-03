a,b,x = map(int, input().split())
if a==0:
    sum = b//x+1
else:
    sum = b//x-(a-1)//x

print(sum)