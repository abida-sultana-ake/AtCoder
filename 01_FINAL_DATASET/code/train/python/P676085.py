s = list(input())
s.sort()
c = s.count('?')
cL = s.count('L')
cR = s.count('R')
cU = s.count('U')
cD = s.count('D')

t = int(input())
x = abs(cL - cR)
y = abs(cU - cD)

if t == 1:
    ans = x + y + c
else:
    ans = x + y
    while c > 0:
        if ans > 0:
            ans -= 1
        else:
            ans += 1
        c -= 1

print(ans)