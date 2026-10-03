n = int(input())
s = input().rstrip()

x = 0
ans = 0
for c in s:
    x += (c == 'I')
    x -= (c == 'D')
    ans = max(ans,x)

print(ans)