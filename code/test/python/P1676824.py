n=int(input())
hh=n//3600
mm=(n-hh*3600)//60
ss=n-hh*3600-mm*60

if len(str(hh))==1:
    hh="0"+str(hh)
if len(str(mm))==1:
    mm="0"+str(mm)
if len(str(ss))==1:
    ss="0"+str(ss)

print(str(hh)+":"+str(mm)+":"+str(ss))