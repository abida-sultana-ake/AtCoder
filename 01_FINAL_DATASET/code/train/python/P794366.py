l=input().split()
ll=[int(i) for i in  l]
x=ll[0]*ll[1]*ll[2]
print(int((x%(10**9+7))))