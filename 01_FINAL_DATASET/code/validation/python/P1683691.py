h, w = [int(i) for i in input().split()]
a = []
a.append(['.'] * (w + 2))
for j in range(h):
    a.append(['.'] + list(input()) + ['.'])
a.append(['.'] * (w + 2))

for j in range(1, h + 1):
    for i in range(1, w + 1):
        if a[j][i] == '.':
            n = [
                a[j - 1][i - 1],
                a[j - 1][i],
                a[j - 1][i + 1],
                a[j][i - 1],
                a[j][i + 1],
                a[j + 1][i - 1],
                a[j + 1][i],
                a[j + 1][i + 1],
            ].count('#')
            print(n, end='')
        else:
            print('#', end='')
    print()
