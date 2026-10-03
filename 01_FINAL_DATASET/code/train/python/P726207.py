from math import *

def ceildiv(a, b):
    return (a + (-a%b)) // b

R, B = (int(n) for n in input().split())
x, y = (int(n) for n in input().split())

if y*R <= B:
    print(R)
elif x*B <= R:
    print(B)
else:
    n = ((y-1)*R + (x-1)*B) // (x*y - 1)
    while not max(0, ceildiv((y*n-B), (y-1))) <= min(n, (R-n) // (x-1)):
        n -= 1
    # while not (0 <= min(n, B-n) and
    #            n * (x-1) * (y-1) <= (R-n)*(y-1) + (B-n)*(x-1)):
    #     n -= 1
    # while not (R >= n and B >= n and (R-n) // (x-1) + (B-n) // (y-1) >= n):
    #     n -= 1
    print(n)
