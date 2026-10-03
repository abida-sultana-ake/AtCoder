n = int(input())
s = [['' for j in range(n)] for i in range(n)]
for i in range(n):
    t = input()
    for j in range(n):
        s[j][n-i-1] = t[j]
for i in range(n):
    print(''.join(s[i]))
