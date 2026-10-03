n = int(input())
ai = list(map(int, input().split()))

ai.sort()

i1 = -1
i2 = -1
b = 0
for i in range(n - 1, b - 1, -1):
    if ai[i - b] == ai[i - 1 - b]:
        b += 1
        if i1 == -1:
            i1 = ai[i - b]
        else:
            i2 = ai[i - b]
            print(i1 * i2)
            break

if i2 == -1:
    print(0)
