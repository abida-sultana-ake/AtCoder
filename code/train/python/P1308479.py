a, b, c = map(int, input().split())
if a + b == c and a - b == c:
    ans = '?'
elif a + b == c:
    ans = '+'
elif a - b == c:
    ans = '-'
else:
    ans = '!'
print(ans)
