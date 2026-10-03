N,L = map(int, input().split())
src = [input() for i in range(L)]
x = input().find('o')

for row in reversed(src):
    if x > 0 and row[x-1] == '-':
        x -= 2
        continue
    if x < 2*(N-1) and row[x+1] == '-':
        x += 2

print(x // 2 + 1)
