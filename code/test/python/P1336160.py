N = int(input())
a = [int(n) for n in input().split()]
result = 9999999999999
for i in range(min(a), max(a)+1):
    t = 0
    for n in a:
        t += abs(n-i)**2
    result = min(result, t)
print(result)