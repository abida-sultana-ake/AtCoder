n = int(input())

num = 0
for i in range(n):
    l, r = map(int, input().split())
    num += r - l + 1

print(num)
