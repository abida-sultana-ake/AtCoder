def get_sum_line(count, val_list):
    len_list = len(val_list)
    sum_line = 0
    for i in range(len_list):
        sum_line += val_list[i] * (i - (len_list - 1 - i))
    return sum_line

n, m = list(map(int, input().split()))
x_list = list(map(int, input().split()))
y_list = list(map(int, input().split()))

sum_x_line = get_sum_line(n, x_list)
sum_y_line = get_sum_line(m, y_list)

ans = int(sum_x_line * sum_y_line % (10**9 + 7))

print(ans)


