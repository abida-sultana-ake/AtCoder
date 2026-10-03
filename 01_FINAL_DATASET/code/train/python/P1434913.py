s = list(input())
n = int(input())
t = [[int(i) for i in input().split()] for i in range(n)] 

for i in range(n) :
  for j in range(100) :
    if t[i][0] - 1 + j >= t[i][1] - 1 - j :
        break
    s[t[i][0] - 1 + j], s[t[i][1] - 1 - j] = s[t[i][1] - 1 - j], s[t[i][0] - 1 + j]
    
print(''.join(s))