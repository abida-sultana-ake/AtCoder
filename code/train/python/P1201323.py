x = int(input())
total = (x//11)*2
if 0 < x % 11 <= 6:
    total += 1
elif 6 < x % 11:
    total += 2
print(total)
