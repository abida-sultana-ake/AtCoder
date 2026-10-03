sx,sy,tx,ty = map(int,input().split())
dx = tx - sx
dy = ty - sy
ans = []
ans.append('U'*dy)
ans.append('R'*dx)
ans.append('D'*dy)
ans.append('L'*(dx+1))

ans.append('U'*(dy+1))
ans.append('R'*(dx+1))
ans.append('D')
ans.append('R')
ans.append('D'*(dy+1))
ans.append('L'*(dx+1))
ans.append('U')

print(*ans,sep='')