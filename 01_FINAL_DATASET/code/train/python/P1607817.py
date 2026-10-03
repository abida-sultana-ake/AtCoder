c = [[]for i in range(4)]
for i in range(4):
    c[i] = list(input())

for i in range(4)[::-1]:
    print("".join(c[i][::-1]))