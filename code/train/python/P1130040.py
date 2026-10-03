css = [input().split() for _ in range(4)]

for rcs in css[::-1]:
    print(*rcs[::-1], sep=" ")
