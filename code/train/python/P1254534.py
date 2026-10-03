a, b, c = [int(i) for i in input().split()]
for i in range(1, b+1):
    if a*i % b == c:
        print("YES")
        break
else: print("NO")

