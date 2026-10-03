def gcd(a, b):
	while b:
		a, b = b, a % b
	return a

def lcm(a, b):
  return a * b // gcd (a, b)

n=int(input())
t=[]
for i in range(n):
 t.append(int(input()))
c=t[0]
for i in range(1,n):
 c=lcm(c,t[i])
print(c)