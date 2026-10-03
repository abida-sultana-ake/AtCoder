W, H, N = map(int, input().split())

left = 0
right = W
top = 0
bottom = H

for _ in range(N):
    xi, yi, ai = map(int, input().split())
    if ai == 1:
        left = max(left, xi)
    elif ai == 2:
        right = min(right, xi)
    elif ai == 3:
        top = max(top, yi)
    elif ai == 4:
        bottom = min(bottom, yi)

        
ans = (bottom - top) * (right - left) if bottom > top and right > left else 0
print(ans)
