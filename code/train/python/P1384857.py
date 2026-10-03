from functools import reduce
h,w = [int(i) for i in input().split()]
a = []
for i in range(0,h):
    a.append('#' + input() + '#')
udFrame = reduce(lambda x,y: x+y, ['#' for i in range(0,w+2)])
print(udFrame)
for pic in a:
    print(pic)
print(udFrame)