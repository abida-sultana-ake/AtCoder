n, m = map(int, input().split(" "))

x = list(map(int, input().split(" ")))
y = list(map(int, input().split(" ")))

MOD = 1000000007;

xsum = 0;
ysum=0;
for i in range(n-1) :
	diff = x[i+1] - x[i]
	xsum += diff * (i+1) % MOD * (n-1-i) % MOD
for i in range(m-1) :
	diff = y[i+1] - y[i]
	ysum += diff * (i+1) % MOD * (m-1-i) % MOD
print(xsum * ysum % MOD);