N = int(input())
c = list(map(int,list(input())))

a = [0 for i in range(4)]

for i in c:
	a[i-1] += 1

print(max(a),min(a))

