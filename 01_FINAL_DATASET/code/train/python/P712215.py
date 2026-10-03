a, b = map(int, input().split())
x = int(b/a)

if(not float(x)==b/a):
  x = x+1

print(x)
