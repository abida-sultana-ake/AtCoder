sx, sy, tx, ty = map(int, input().split())
w, h = tx-sx+1, ty-sy+1

print('U'*(h-1) + 'R'*w + 'D'*h + 'L'*w + 'UL' + 'U'*h + 'R'*w + 'D'*h + 'L'*(w-1))