a = input()
s = list(a)
n = len(a)
ans = 1
con = 0
if s[n-1] == 'c' :
    ans = 0
else :
  for i in range(n) :
    if con == 1 :
        con = 0
        continue
    if s[i] == 'c' and s[i + 1] == 'h' :
        ans = 1
        con = 1
    elif s[i] == 'o' or s[i] == 'k' or s[i] == 'u' :
        ans = 1
    else :
        ans = 0
        break

if ans == 0 :
    print('NO')
else :
    print('YES')
