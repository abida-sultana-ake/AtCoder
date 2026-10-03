import sys
N=int(input())
S=str(input())
M=str(input())
Mo=10**9+7
ans=1
i=0
if S[i]==M[i]:
  Ag=1
  ans=ans*3
  i+=1
else:
  Ag=2
  ans=ans*6
  i+=2
while i<N:
  if S[i]==M[i]:
    if Ag==1:#連続で楯だった
      ans=ans*2%Mo
      Ag=1
      i+=1
    elif Ag==2:#横の次のたてだった
      Ag=1
      i+=1
  else:#よこがでた
    if Ag==1:#たてのつぎのよこだった
      ans=ans*2%Mo
      Ag=2
      i+=2
    elif Ag==2:#連続でよこだった
      ans=ans*3%Mo
      Ag==2
      i+=2
print(ans%Mo)      