(a, b, c) = map(int, input().split())

ans = a+b+c - max(a,b,c)
print(ans)