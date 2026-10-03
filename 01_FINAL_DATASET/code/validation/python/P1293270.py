n = int(input())
s = input()
ma = 0
v = 0
for i in range(n):
    if s[i] == 'I':
        v += 1
    else:
        v -= 1
    ma = max(ma, v)
print(ma)
