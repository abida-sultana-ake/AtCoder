n=(int(input()))%30
l=[str(i) for i in range(1,7)]
for i in range(n):
  a=l.pop(i%5)
  l.insert(i%5+1,a)
print(''.join(l))