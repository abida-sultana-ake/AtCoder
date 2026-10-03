N, x = [int(x) for x in input().split()]
arr = [int(x) for x in input().split()]
ans = 0
for i, a in enumerate(arr):

    if i == 0:
        if a - x > 0:
            ans += a-x
            arr[i] -= a-x
    elif a+arr[i-1]-x > 0:
            ans += a+arr[i-1]-x
            arr[i] = -arr[i-1]+x

print(ans)