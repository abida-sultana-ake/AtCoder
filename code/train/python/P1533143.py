s = list(map(int, input().split()))
p = list(map(int, input().split()))

p.sort(reverse = True)
c = 0
for i in range(s[1]):
    c = (c + p[s[1] - i - 1])/2
print(c)
