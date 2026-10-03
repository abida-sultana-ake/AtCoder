R=int(input())
t=[]
for _ in range(R):
  t.append(input())
ans=0
for c in range(9):
  p = None
  for r in range(R):
    if t[r][c] == 'x':
      ans += 1
    if t[r][c] == 'o' and t[r][c] != p:
      ans += 1
    p = t[r][c]
print(ans)