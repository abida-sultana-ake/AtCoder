list = input().split()
a = int(list[0])
b = int(list[1])
c = int(list[2])

if a+b == c:
   print("Yes")
elif a+c == b:
   print("Yes")
elif b+c == a:
   print("Yes")
else:
   print("No")