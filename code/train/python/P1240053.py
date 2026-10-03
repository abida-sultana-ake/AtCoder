s = input()

x = 0
for i in range(0, 4):
    for y in range(i + 1, 4):
        if s[i] == s[y]:
            x += 1
            break

if x == 3:
    print("SAME")
else:
    print("DIFFERENT")