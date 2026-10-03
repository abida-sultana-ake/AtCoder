
T = int(input().split(" ")[1])
t = [int(x) for x in input().split(" ")]
t.append(100000000000)

ret = 0

for i in range(len(t)-1):
	ret += min(T,t[i+1] - t[i])

print(ret)