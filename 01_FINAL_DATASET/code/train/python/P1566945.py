n, x = map(int, input().split())
a = list(map(int, input().split()))
price_sum = 0

'''
i = 0
while x > 0:
    if x % 2 == 1:
        price_sum += a[i]
    x //= 2
    i += 1

print(price_sum)
'''

bin_x = format(x, 'b').zfill(n)

for i in range(n):
    if bin_x[n-1-i] == '1':
        price_sum += a[i]

print(price_sum)
