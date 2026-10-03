
def spaceinput():
    return list(map(int,input().split(" ")))

a,b,c,d,e,f=spaceinput()


smax=0
wmax=100*a
maxnoudo=0

for na in range(int(f/(100*a))+1):
    for nb in range(int(f/(100*b))+1):
        for nc in range(int(f/c)+2):
            for nd in range(int(f/d)+2):
                W=na*100*a+nb*100*b
                S=nc*c+nd*d


                if W+S>f:
                    break

                if W+S==0:
                    continue

                noudo=S/(W+S)
                #print(noudo,S,W,f,e)
                #print("aaa")
                if noudo>e/(100+e):
                    break

                #print(na,nb,nc,nd)
                if maxnoudo<noudo:
                    maxnoudo=noudo
                    smax=S
                    wmax=W
                    #input()


print(smax+wmax,smax)
