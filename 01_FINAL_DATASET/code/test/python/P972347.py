W, H, N = map(int, input().split())

w_min = 0; w_max = W
h_min = 0; h_max = H
curr_area = W * H

for i in range(N):
    x, y, a = map(int, input().split())
    if a == 1 and x > w_min:
        if x >= w_max:
            curr_area = 0
            break
        else:
            w_min = x

    elif a == 2 and x < w_max:
        if x <= w_min:
            curr_area = 0
            break
        else:
            w_max = x
    elif a == 3 and y > h_min:
        if y >= h_max:
            curr_area = 0
            break
        else:
            h_min = y
    elif a == 4 and y < h_max:
        if y <= h_min:
            curr_area = 0
            break
        else:
            h_max = y
    curr_area = (w_max - w_min) * (h_max - h_min)
print(curr_area)
