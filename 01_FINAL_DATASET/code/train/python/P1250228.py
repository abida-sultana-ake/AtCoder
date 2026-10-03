import sys
A , B , C = map(int, input().split())

for x in range(1,101):
    for y in range(1,101):
        if A*x % B*y == C:
            print("YES")
            sys.exit()
else:
    print("NO")