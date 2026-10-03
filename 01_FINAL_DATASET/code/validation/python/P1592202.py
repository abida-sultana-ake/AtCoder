H, W = map(int, input().split())
N = int(input())
a = list(map(int, input().split()))
 
i = 0

for x in range(H):
    c = []
    for y in range(W):
        c.append(i + 1)
        a[i] -= 1
        if a[i] == 0:
            i += 1
            
    if x % 2 == 0:
        print(*c)
        print()
    else:
        print(*c[::-1])
        print()