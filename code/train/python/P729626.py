N = int(input())

magic1 = []
magic2 = []

for i in range(N):
    a, b = map(int, input().split())
    if a < b:
        magic1.append((a, b))
    else:
        magic2.append((a, b))

magic1.sort(key=lambda x:x[1])
magic1.sort(key=lambda x:x[0])
magic2.sort(key=lambda x:x[0], reverse=True)
magic2.sort(key=lambda x:x[1], reverse=True)
magics = magic1 + magic2

M = 0
temp = 0

for a, b in magics:
    if temp + a > M:
        M = temp + a
    temp += a - b

print(M)