s=str(input())
k=int(input())
count={}

if len(s)<k:
 print(len(count))
else:
 for times in range(0,len(s)-k+1):
  count[s[times:times+k]]=0
 else:
  print(len(count))