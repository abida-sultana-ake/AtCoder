n = int(input())

a, b = map(int, input().split())

for _ in range(n-1):
    x, y = map(int, input().split())
    p = max(a // x, b // y)
    while x * p < a or y * p < b:
        p += 1
    a, b = x * p, y * p
    
print(a + b)
    