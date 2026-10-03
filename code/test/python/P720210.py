n = k = 0

l = list(map(int, input().split()))
n = l[0]
k = l[1]
ai = list(map(int, input().split()))

a = 0
suma = 0
for i in range(k):
    a = a + ai[i]
suma = a
for i in range(1, n - k + 1):
    a = a - ai[i-1] + ai[i+k-1]
    suma = suma  + a

print(suma)
