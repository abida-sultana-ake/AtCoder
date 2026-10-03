N = int(input())
a = list(map(int,input().split()))
one = 0
four = 0
two = 0

for j in range(N):

  if a[j]%2 == 1:
    one += 1
  elif a[j]%4 == 0:
    four += 1
  else :
    two +=1

print("Yes" if four >= one or (four == one - 1 and two == 0) else "No")