N, M = map(int, input().split())
X, Y = map(int, input().split())
a = sorted([int(s) for s in input().split()], reverse=True)
b = sorted([int(s) for s in input().split()], reverse=True)

time = 0
result = 0
try:
    while a and b:
        while 1:
            t = a.pop()
            if t >= time:
                time = t+X
                break
        while 1:
            t = b.pop()
            if t >= time:
                time = t+Y
                result += 1
                break

except IndexError:
    print(result)
else:
    print(result)