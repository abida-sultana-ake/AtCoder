# -*- coding: utf-8 -*-
# 整数の入力
n=int(input())
a=list(map(int, input().split()))
b=a[:]
c=a[:]
# a[0]の符号をそのままにした場合の計算
counter_1=0
S=int(a[0])
for i in range(1,n):
  if S<0 and S+int(a[i])<=0:
    counter_1+=-S-int(a[i])+1
    a[i]=-S+1
  elif S>0 and S+int(a[i])>=0:
    counter_1+=S+int(a[i])+1
    a[i]=-S-1
  S+=int(a[i])
# a[0]を1に変えた場合の計算
counter_2=abs(int(b[0])-1)
b[0]=1
S=b[0]
for i in range(1,n):
  if S<0 and S+int(b[i])<=0:
    counter_2+=-S-int(b[i])+1
    b[i]=-S+1
  elif S>0 and S+int(b[i])>=0:
    counter_2+=S+int(b[i])+1
    b[i]=-S-1
  S+=int(b[i])
# a[0]を-1に変えた場合の計算
counter_3=abs(int(c[0])+1)
c[0]=-1
S=c[0]
for i in range(1,n):
  if S<0 and S+int(c[i])<=0:
    counter_3+=-S-int(c[i])+1
    c[i]=-S+1
  elif S>0 and S+int(c[i])>=0:
    counter_3+=S+int(c[i])+1
    c[i]=-S-1
  S+=int(c[i])
print(min(counter_1,counter_2,counter_3))