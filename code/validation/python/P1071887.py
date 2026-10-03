N = int(input())
S = input()
x = 0
xmax = 0
for i in S:
    if i == "I":
        x += 1
    else:
        x -= 1
    if x > xmax:
        xmax = x
print(xmax)