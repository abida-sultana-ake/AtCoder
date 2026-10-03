def opp(ch):
  if ch == "W": return "S"
  if ch == "S": return "W"
def test(th, nb, ans):
  if th == "S":
    if ans == "o": return nb
    if ans == "x": return opp(nb)
  if th == "W":
    if ans == "x": return nb
    if ans == "o": return opp(nb)
  
n = int(input().strip())
s = list(input())
res_list = [[x, y] for x in "SW" for y in "SW"] 
for ch in s[1:-1]:
  for res in res_list:
    res.append(test(res[-1], res[-2], ch))
    
for res in res_list:
  if test(res[-1], res[-2], s[-1]) == res[0] and test(res[0], res[-1], s[0])  == res[1]:
    print("".join(res))
    break
else:
  print(-1)   
  