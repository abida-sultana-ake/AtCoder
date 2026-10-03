r, g, b = map(int, input().split())

if (r*100+g*10+b)%4 == 0:
    print("YES")
else:
    print("NO")