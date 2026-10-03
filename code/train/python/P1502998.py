N = int(input())
a = list(map(int,input().split()))

count = 0
C = 0
res = 0
a.append(0)

for i in range(N):
  if a[i] < a[i+1]:
    count += 1
    C += count 
  else :
    res += C
    count =0
    C  = 0

print(res+N)