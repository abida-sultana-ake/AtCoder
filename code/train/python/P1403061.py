N, K = map(int, input().split())
a = list(map(int, input().split()))

a = sorted(a)
ans = N
psum = 0
for i in range(N-1, -1, -1) :
    if psum+a[i] < K :
        psum += a[i]
    else :
        ans = min(ans, i)

print(ans)