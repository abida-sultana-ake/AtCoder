A = [ [ int(x) for x in input().split()] for _ in range(4) ]
end = True
for r in range(4):
  for c in range(4):
    if r + 1 < 4 and A[r][c] == A[r+1][c]:
      end = False
    if c + 1 < 4 and A[r][c] == A[r][c+1]:
      end = False
print( 'GAMEOVER' if end else 'CONTINUE' )