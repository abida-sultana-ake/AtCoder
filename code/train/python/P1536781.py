import sys
s=str(input())
while s!="":
  N=len(s)
  if len(s)>1 and s[N-2]+s[N-1]=="ch":
    s=s[:N-2]
  elif s[N-1]=="o" or s[N-1]=="k" or s[N-1]=="u":
    s=s[:N-1]
  else:
    print("NO")
    sys.exit()
print("YES")