x,y=map(int,input().split())
A=[1, 3, 5, 7, 8, 10, 12]
B=[4, 6, 9, 11]
C=[2]
if x in A:
  a=1
elif x in B:
  a=2
else:
  a=3
if y in A:
  b=1
elif y in B:
  b=2
else:
  b=3
if a==b:
  print("Yes")
else:
  print("No")