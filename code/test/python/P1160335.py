N=int(input())
h=N/3600
N=N%3600
m=N/60
N=N%60
print(str(h).zfill(2)+":"+str(m).zfill(2)+":"+str(N).zfill(2))
