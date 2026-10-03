import math

l = input().split()

if l[0] == 'H':
    if l[1] == 'H':
        result = 'H'
    else:
        result = 'D'
else:
    if l[1] == 'H':
        result = 'D'
    else:
        result = 'H'

print(result)


