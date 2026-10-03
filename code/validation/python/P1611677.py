N, L = list(map(int, input().split()))
a = [input() for i in range(L+1)]

pos = 0
for i in range(0, 2*N-1, 2):
    if a[L][i] == 'o':
        pos = i

y = L
while y > 0:
    y -= 1
    if pos > 0 and a[y][pos-1] == '-':
        pos -= 2
    elif pos < 2*N-2 and a[y][pos+1] == '-':
        pos += 2
print((pos+2)//2)