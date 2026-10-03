r, g, b = input().split()

res = int(r + g + b)

if res % 4 == 0:
    print("YES")
else:
    print("NO")