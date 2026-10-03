ans = 0

n = int(input())
s = [int(input()) for i in range(n)]
s.sort()

for i in range(n-1) :
    if s[i] == s[i+1] :
        ans = ans + 1

print (ans)