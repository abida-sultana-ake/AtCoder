import math

def Comb (n,m):
    if n < m:
        return 0
    f = math.factorial
    Comb = f(n)//f(m)//f(n-m)
    return Comb

def calc (xy,d,l):
   return Comb(xy,d)*Comb(xy-d,l) 

if __name__ == '__main__':
    R,C = list(map(int,input().split()))
    X,Y = list(map(int,input().split()))
    D,L = list(map(int,input().split()))
    

    comb = calc(X*Y,D,L) #X*Y>D+Lの時の全組合せを求める。X*Y=D+Lの時X*Y-D=Lになるのでx*yCd*1となる。
    
    if X*Y != D+L:
        #すべてのケースから壁にぴったりくっついていないケースを求める
        comb -= calc((X-1)*Y,D,L)*2     #左右どちらかにくっついていないケースは同じ値なので、一方を2倍することで横にくっついていないケースを求められる。
        comb -= calc(X*(Y-1),D,L)*2     #上下の場合も同じ
        
        comb += calc((X-1)*(Y-1),D,L)*4 #（右,上）(右,下),（左,上）（左,下）の４パターン
        comb += calc((X-2)*Y,D,L) #（右,左）
        comb += calc(X*(Y-2),D,L) #（上、下）

        comb -= calc((X-2)*(Y-1),D,L)*2 #（右,左,上）（右,左,下）
        comb -= calc((X-1)*(Y-2),D,L)*2 #(右,上,下)(左,上,下)

        comb += calc((X-2)*(Y-2),D,L)
    res = ((R-X+1)*(C-Y+1)*comb)%1000000007
    print(res)

