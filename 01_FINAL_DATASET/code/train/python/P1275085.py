import sys
N,K=map(int, input().split())
a=list(map(int, input().split()))
sum=0
for i in range(0,N):
  sum+=a[i]
if sum<K:#全部不必要
  print(N)
  sys.exit()
if sum==K:#全部必要
  print(0)
  sys.exit()
a.sort()
a.reverse()
 
#K未満の最大の数字のラベルはどこ？
l=N
for i in range(N-1,-1,-1):
  if a[i]<K:
    l=i
  else:
    break
 
if l==N:
  print(0)
  sys.exit()
 
count=N
#lまでの要素が必要か不要かチェック(使いまわし可能)
sum=0
l_list=[]
for j in range(l,N):
  if sum+a[j]<K:
    sum+=a[j]
    l_list.append(a[j])
for i in range(0,l):  
  if sum+a[i]>=K:#必要ってことだ
    count-=1
#lからの要素は自分のことを抜かないといけないことに注意
for i in range(l,N):
  if a[i] in l_list:
    sum=0
    b=a[:]
    C=b.pop(i)
    for j in range(l-1,N-1):
      if sum+b[j]<K:
        sum+=b[j]
    if sum+C>=K:#必要ってことだ
      count-=1
  else:
    count-=1
print(count)