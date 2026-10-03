x = list(map(int, input().split()))

m = x[0]
d = x[1]
if m % d == 0:
    print("YES")
else:
    print("NO")