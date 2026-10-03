n = int(input())
a = list(map(int, input().split()))

one = 0
two = 0
four = 0

for i in a:
    if i % 4 == 0:
        four += 1
    elif i % 2 == 0:
        two += 1
    else:
        one += 1

print("Yes" if four >= one or (four == one - 1 and two == 0) else "No")
