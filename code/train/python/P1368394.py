#abc009b
n = int(input())
s = [int(input()) for i in range(n)]
s.sort()
maxValue = s[n - 1]
an = -1
for i in range(n) :
  if s[i] == maxValue :
    an = s[i - 1]
    break
print(an)