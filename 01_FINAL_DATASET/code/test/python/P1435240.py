N, a = map(int, input().split())
k = int(input())
b = tuple(map(int, input().split()))

current = a
visited = {a: k}
flag = True
while k > 0:
    k -= 1
    current = b[current-1]
    if current not in visited:
        visited[current] = k
    elif flag:
        cycle = visited[current] - k
        k %= cycle
        flag = False

print(current)