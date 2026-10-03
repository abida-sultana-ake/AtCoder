N, M = map(int, input().split())
a = [0] * (M+1)
total = 0
for i in range(N):
    l, r, s = map(int, input().split())
    a[l-1] += s
    a[r] -= s
    total += s
a = [(l.append(l[-1]+n), l[-1])[1] for l in [[0]] for n in a[:-1]]
print(total - min(a))