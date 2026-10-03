n = list(map(int, input().split(" ")))

if n.count(5) == 2 and n.count(7) == 1:
    print("YES")
else:
    print("NO")