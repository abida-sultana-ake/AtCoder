def main(sx, sy, tx, ty):
    answer = ''
    d_x = tx - sx
    d_y = ty - sy

    one_right = 'R' * d_x
    one_up    = 'U' * d_y
    answer += one_up + one_right

    one_down  = 'D' * d_y
    one_left  = 'L' * (d_x + 1)
    answer += one_down + one_left

    two_up    = 'U' * (d_y + 1)
    two_right = 'R' * (d_x + 1)
    answer += two_up + two_right + 'DR'

    two_down  = 'D' * (d_y + 1)
    two_left  = 'L' * (d_x + 1)
    answer += two_down + two_left + 'U'

    return answer

# print(main(
#     0, 0, 1, 2
# ))

if __name__ == '__main__':
    sx, sy, tx, ty = [int(e) for e in input().split()]
    print(main(sx, sy, tx, ty))
