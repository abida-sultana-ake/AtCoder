def read_line(*types): return [f(a) for a, f in zip(input().split(), types)]

n,  = read_line(int)

m = 1000000007

domino = []
domino.append(input())
domino.append(input())

# print(domino[0])
# print(domino[1])

def compress(line):
    x = [line[0]]
    for c in line[1:]:
        if x[-1] != c:
            x.append(c)
    return x

domino[0] = compress(domino[0])
domino[1] = compress(domino[1])

xs = []
for i in range(len(domino[0])):
    xs.append(domino[0][i] != domino[1][i])
# print(xs)

patterns = None
if xs[0]:
    patterns = 6
else:
    patterns = 3

lastX = xs[0]
for x in xs[1:]:
    if x:
        # T -> T
        if lastX:
            patterns *= 3
        else:
            # F -> T
            patterns *= 2
    else:
        # T -> F
        if lastX:
            patterns *= 1
        else: # F -> F
            patterns *= 2
    lastX = x

print(patterns % m)

# T -> T

# 6 * 4 = 24

# 0|1120
# 1|2002

# 0
# 2

# 1
# 0

# 1
# 2

# 2
# 0

# 2
# 1


# F -> T

# 3 * 2 = 6

# 0|12
# 0|21
# 
# 1|02
# 1|20
# 
# 2|10
# 2|01


# T -> F

# 6 * 1 = 6

# 0|2
# 1|2

# 0|1
# 2|1

# 1|2
# 0|2

# 1|0
# 2|0

# 2|1
# 0|1

# 2|0
# 1|0

# F -> F

# 3 * 2 = 6

# 0 | 12
# 1 | 02
# 2 | 01
