x = int(input())
quot = x//11
if x >= 11:
    quot *= 2
remainder = x%11
if remainder > 6:
    quot += 2
else:
    if remainder != 0:
        quot += 1
print(quot)
