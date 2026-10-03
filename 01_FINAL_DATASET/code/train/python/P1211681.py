s = input()
t = input()
n = int(input())

a = [[0 for i in range(4)] for j in range(n)]
for i in range(n):
    a[i] = [int(j)-1 for j in input().split()]

def henkan(inp, n):
    o = [0] * n
    for i in range(n):
        if inp[i] == 'A':
            o[i] = 1
        else:
            o[i] = 2
    return o

def ruiseki(a, n):
    s = [0] * n
    s[0] = a[0]
    for i in range(1,n):
        s[i] =  s[i-1] + a[i]
    return s

def partSum(s, l, r):
    if l == 0:
        return s[r]
    return s[r] - s[l-1]

s_i = henkan(s,len(s))
t_i = henkan(t,len(t))

sum_s = ruiseki(s_i, len(s_i))
sum_t = ruiseki(t_i, len(t_i))

for i in range(n):
    x = partSum(sum_s, a[i][0], a[i][1])
    y = partSum(sum_t, a[i][2], a[i][3])
    if x%3 == y%3:
        print('YES')
    else:
        print('NO')
