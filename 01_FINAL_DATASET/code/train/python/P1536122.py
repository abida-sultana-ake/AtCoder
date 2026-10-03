s = input()
tc = [ chr(i)*2 for i in range(ord('a'), ord('z')+1) ]  + [ chr(i)+chr(j)+chr(i) for i in range(ord('a'), ord('z')+1) for j in range(ord('a'), ord('z')+1)]
x=y=-1
t = "0"
for i in set(tc):
  if i in s:
    t = i
for i in range(len(s)):
    if s[i:i+len(t)] == t:
      x = i+1
      y = i+len(t)
print(x, y)