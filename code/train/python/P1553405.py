O,E = input(), input()
ans = ''
for a,b in zip(O,E):
    ans += a
    ans += b
if len(O) > len(E): ans += O[-1]
print(ans)
