
sx,sy,tx,ty = map( int, input().split() )
ruto = []

for i in range(0,tx-sx):
    ruto.append("R")
for i in range(0,ty-sy):
    ruto.append("U")
for i in range(0,tx-sx):
    ruto.append("L")
for i in range(0,ty-sy):
    ruto.append("D")

ruto.append("D")
for i in range(0,tx-sx+1):
    ruto.append("R")
for i in range(0,ty-sy+1):
    ruto.append("U")
ruto.append("L")
ruto.append("U")
for i in range(0,tx-sx+1):
    ruto.append("L")
for i in range(0,ty-sy+1):
    ruto.append("D")
ruto.append("R")




for i in range(0,len(ruto)):
    print(ruto[i],end="")