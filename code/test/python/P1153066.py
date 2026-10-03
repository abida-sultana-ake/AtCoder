import sys

n, a = map(int, input().split())
a -= 1
k = int(input())
b = list(map(int, input().split()))

b = list(map(lambda x:x-1, b))

route = [a]
appeared = set()
appeared.add(a)
while True:
    route.append(b[route[-1]])
    if route[-1] in appeared:
        break
    else:
        appeared.add(route[-1])

if k < len(route):
    print(route[k] + 1)
    sys.exit()

ind = route.index(route[-1])
k -= ind
k %= (len(route) - 1 - ind)
print(route[ind + k] + 1)
