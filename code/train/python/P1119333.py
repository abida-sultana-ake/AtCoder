n,a,b=map(int,input().split())
print(['Bug','Ant'][0<n%(a+b)<=a])