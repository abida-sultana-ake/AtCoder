p = lambda  x: x#print(x)

# スペース区切りの整数の入力
N = int(input())

l = [int(i) for i in input().split()]

# X = sum(l)
# x = 0
# ans = 1000000000000000000
# 
# for i in range(N-1):
# 	x += l[i]
# 	ans = min(ans, abs(X-2*x))
# 
# print(ans)

p(N)
p(l)

s = 0
a = sum(l)
ans = float('inf') 

p("s=" + str(s))
p("ans=" + str(ans))
p("a=" + str(a))
p("abs(s - a)=" + str(abs(s - a)))


for i in range(0, N-1):
	s += l[i]
	a -= l[i]
	ans = min(ans, abs(s-a))

print(ans)
