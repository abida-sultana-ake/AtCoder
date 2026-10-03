
N = int(input())
x = list(map(int, input().split()))

y=sorted(x)
width=[0,0]
height=[0,0]


for i in range(0,len(y)-1):
    if (y[len(y)-1-i]==y[len(y)-2-i] and width[0]==0):
        width[0]=y[len(y)-1-i]
        width[1]=len(y)-1-i
        continue
    if (width!=0 and y[len(y)-1-i]==y[len(y)-2-i]):
        if(len(y)-1-i==width[1]-1):
            continue
        height[0]=y[len(y)-1-i]
        break



print('{0}'.format(int(width[0])*int(height[0])))



quit()
