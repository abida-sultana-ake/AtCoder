n = int(input())
a = [int(x) for x in input().split()]
b = []
stack = []
a.reverse()
for i in range(n):
    if i%2 == 0:
        b.append(a[i])
    else:
        stack.append(a[i])
for i in range(len(stack)):
    b.append(stack.pop())

print(" ".join(map(str, b)))
