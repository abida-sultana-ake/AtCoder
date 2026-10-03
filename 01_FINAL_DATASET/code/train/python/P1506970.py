def gcd(a, b):
	while b:
		a, b = b, a % b
	return a

def lcm(a, b):
	return a * b // gcd (a, b)

n = int(input())
l = int(input())

i = 1

while i < n:
    l = lcm(l, int(input()))
    i = i + 1

print(l)
