a, b, c = map(int, input().split())

if a == b+c or b == a+c or c == b+a:
 print("Yes")
else:
 print("No")