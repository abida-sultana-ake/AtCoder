n = int(input())
s = input()

f = "b"
for i in range(100):
 if f == s:
  print(i)
  break
 if i%3 == 0:
  f = "a" + f + "c"
 elif i%3 == 1:
  f = "c" + f + "a"
 else:
  f = "b" + f + "b"
else:
 print(-1)