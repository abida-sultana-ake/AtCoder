basex,basey,a,b,c,d=map(int,input().split())
print(abs((a-basex)*(d-basey)-(b-basey)*(c-basex))/2.0)