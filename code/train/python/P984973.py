C = int(1e9) + 7
H, W, A, B = map(int, input().split())

fact = [1]
for x in range(1, H + W - 2):
	fact.append( (x * fact[x-1]) % C )

factinv = [1] * (H + W -2)
factinv[H + W - 3] = pow(fact[H + W -3], C-2, C)

for x in reversed(range(2, H + W -3)):
	factinv[x] = ( factinv[x+1] * (x+1) ) % C

def nCr(n,r):
	return ( fact[n] * factinv[r] * factinv[n-r] ) % C

ans = 0
for i in range(B,W):
	ans = (ans + nCr(i+H-A-1, H-A-1) * nCr(A-1+W-i-1, A-1)) % C
	
print(ans)