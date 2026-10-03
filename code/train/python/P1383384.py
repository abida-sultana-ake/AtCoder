S=str(input())
T=int(input())
u=abs(S.count("U")-S.count("D"))
l=abs(S.count("L")-S.count("R"))
q=S.count("?")
if T==1:
  print(u+l+q)
else:
  if q<=u+l:
    print(u+l-q)
  elif len(S)%2==0:
    print(0)
  else:
    print(1)
    