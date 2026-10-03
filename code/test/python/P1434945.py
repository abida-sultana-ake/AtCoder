n = int(input())
s = [input() for i in range(n)] 
s = s + ['zzzzzzz']
s.sort()
count = 1
max = 0
ans = '\0'

for i in range(n) :
    if s[i] == s[i+1] :
        count = count + 1
    else :
        if max < count :
             max = count
             ans = s[i] 
        count = 1

print(ans)