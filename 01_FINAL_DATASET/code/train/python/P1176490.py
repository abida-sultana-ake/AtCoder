n = int(input())
ng = [int(input()) for i in range(3)]
ans = "YES"
if n in ng:
    ans = "NO"
for i in range(100):
    if n - 3 not in ng:
        n -= 3
    elif n - 2 not in ng:
        n -= 2
    elif n - 1 not in ng:
        n -= 1
    else:
        ans = "NO"
if n > 0:
    ans = "NO"
print(ans)
