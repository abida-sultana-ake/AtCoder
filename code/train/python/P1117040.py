inp = list(map(int, input().split()))

#print(inp)
s = inp[0]
c = inp[1]

ans = 0
if s*2 <= c:
    ans += s
    c -= 2*s
    s = 0
    if c>=4:
        ans += c//4
elif c//2<=s:
        ans += c//2
        s -= c//2
        c -= 0
else:
    if c>=4:
        ans += c//4



print (ans)