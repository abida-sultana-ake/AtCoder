MAX = 1000000007

w, h = map(int, input().split())
w -= 1
h -= 1

wp = 1

a = 1
for i in range(w + h, w, -1):
    a *= i
    if a >= MAX:
        a %= MAX

def powmod(a, b, p):
    if b == 0:
        return 1
    if b & 1:
        return (a * powmod(a, b - 1, p)) % p
    else:
        d = powmod(a, b // 2, p)
        return (d * d) % p

b = 1
for i in range(2, h + 1):
    b *= i
    if b >= MAX:
        b %= MAX

print((a * powmod(b, MAX - 2, MAX)) % MAX)
