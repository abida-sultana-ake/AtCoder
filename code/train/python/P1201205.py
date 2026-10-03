n = int(input())
a = list(map(int,input().split(' ')))

t_point = []
for i in range(n):
    a_point = []
    for j in range(n):
        if i == j:
            a_point.append(-10000)
        else:
            if i < j:
                t = a[i:j+1]
            else:
                t = a[j:i+1]
            a_point.append(sum([t[k] for k in range(1,len(t),2)]))
    aoki_j = a_point.index(max(a_point))
    if i < aoki_j:
        t = a[i:aoki_j+1]
    else:
        t = a[aoki_j:i+1]
    t_point.append(sum([t[k] for k in range(0,len(t),2)]))
print(max(t_point))