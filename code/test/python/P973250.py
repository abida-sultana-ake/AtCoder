def makemap(x,y):
    multilist = [[0 for col in range(y)] for row in range(x)]
    return multilist

def drow(X,Y,x,y,a,multilist):
    if a ==1 :
        for i in range(0,x):
            for j in range(0,Y):
                multilist[i][j]=1
    elif a ==2 :
        for i in range(x,X):
            for j in range(0,Y):
                multilist[i][j]=1
         
    elif a ==3 :
        for i in range(0,X):
            for j in range(0,y):
                multilist[i][j]=1
         
    elif a ==4 :
        for i in range(0,X):
            for j in range(y,Y):
                multilist[i][j]=1
    
    return multilist
    

def main():
    X,Y,N = map(int,input().split())
    mapx=makemap(X,Y)
    count = 0
    for k in range(0,N):
        x,y,a = map(int,input().split())
        mapx = drow(X,Y,x,y,a,mapx)
    for i in range(0,X):
        for j in range(0,Y):
            if mapx[i][j]==0:
                count+=1
    print(count)
    
main()
