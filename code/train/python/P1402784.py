a = input()
s = list(a)
n = len(a)
count = 1

for i in range(n-1) :
  if s[i] == s[i+1] :
      count += 1
  else :
      print(s[i], end = '')
      print(count, end = '')
      count = 1

print(s[n-1], end = '')
print(count, end = '')
print()