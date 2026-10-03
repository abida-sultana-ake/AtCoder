sx, sy, tx, ty = list(map(int, input().split()))

diff_x = tx - sx
diff_y = ty - sy

print('R'*diff_x + 'U'*diff_y + 'L'*diff_x + 'D'*diff_y
      + 'D' + 'R'*(diff_x+1) + 'U'*(diff_y+1) + 'L'
      + 'U' + 'L'*(diff_x+1) + 'D'*(diff_y+1) + 'R')
