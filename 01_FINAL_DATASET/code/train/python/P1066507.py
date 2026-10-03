N, A, B = map(int, input().split())
X = list(map(int, input().split()))
X2 = [x*A for x in X]
ans = 0
a = X2[0]
for i in X2[1:]:
    b = i - a
    if b > B:
        ans += B
    else:
        ans += b
    a = i
print(ans)