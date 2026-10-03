def check(ssum, tsum, a, b, c, d):
    return ((ssum[b] - ssum[a - 1]) - (tsum[d] - tsum[c - 1])) % 3 == 0

s = input()
t = input()
q = int(input())
a = [[int(i) for i in input().split()] for j in range(q)]

ssum = [0]
tsum = [0]
for i in range(len(s)):
    if s[i] == 'A':
        temp = 1
    else:
        temp = 2
    ssum.append(ssum[i] + temp)
for i in range(len(t)):
    if t[i] == 'A':
        temp = 1
    else:
        temp = 2
    tsum.append(tsum[i] + temp)

for i in range(q):
    if check(ssum, tsum, a[i][0], a[i][1], a[i][2], a[i][3]):
        print('YES')
    else:
        print('NO')
