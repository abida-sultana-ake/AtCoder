import collections
n = int(input())
a = list(map(int, input().split()))
b = collections.deque()

for i in range(n):
    if i % 2 == 0:
        b.appendleft(a[i])
    else:
        b.append(a[i])
if n % 2 == 0:
    b.reverse()
print(*b)
