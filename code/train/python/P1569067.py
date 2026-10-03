n,a,b=map(int,input().split())
arr=[list(map(str,input().split())) for _ in range(n)]
x=0
def s(direction):
    if direction=="East":
        return 1
    else:
        return -1
for i in range(n):
    if int(arr[i][1])<a:
        x+=s(arr[i][0])*a
    elif int(arr[i][1])>b:
        x+=s(arr[i][0])*b
    else:
        x+=s(arr[i][0])*int(arr[i][1])
if x>0:
    print("East",x)
elif x<0:
    print("West",abs(x))
else:
    print(0)