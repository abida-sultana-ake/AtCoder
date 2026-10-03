import sys
inp=sys.stdin.readline()
sx,sy,tx,ty=map(lambda x: int(x), inp.split(' '))
ret=''
for i in range(ty-sy):
    ret=ret+'U'
for i in range(tx-sx):
    ret=ret+'R'
for i in range(ty-sy):
    ret=ret+'D'
for i in range(tx-sx+1):
    ret=ret+'L'
for i in range(ty-sy+1):
    ret=ret+'U'
for i in range(tx-sx+1):
    ret=ret+'R'
ret=ret+'DR'
for i in range(ty-sy+1):
    ret=ret+'D'
for i in range(tx-sx+1):
    ret=ret+'L'
ret=ret+'U'
print(ret)