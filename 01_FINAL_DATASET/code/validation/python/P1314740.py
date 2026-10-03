a = int(input())
b = list(map(int,input().split()))
c = 0
count = 0
for i in range(a) :
  if b[i] != 0 :
    c += b[i]
    count = count + 1
print (int(c / count + 0.9999999))