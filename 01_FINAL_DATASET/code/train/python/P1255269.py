a, b, c, k = [int(i) for i in input().split()]
s, t = [int(i) for i in input().split()]
if (s+t) >= k:
    ans = s*(a-c) + t*(b-c)
else:
    ans = s*a + t*b 

print(ans)
