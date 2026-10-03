N, M, D = map(int, input().split())
a = [i for i in range(N)]
for n in (int(n) for n in input().split()):
    n -= 1
    a[n], a[n+1] = a[n+1], a[n]
_a = [0]*N
for i in range(N):
    _a[a[i]] = i
a2 = [[] for i in range(N)]

for i in range(N):
    this = a2[i]
    if this:
        print(this)
    else:
        n = i
        flag = False
        for j in range(D):
            n = _a[n]
            if n == i:
                this.append(n)
                flag = True
                break
            this.append(n)
        l = len(this)
        key = (D-1)%l
        print(this[key]+1)
        if flag:
            for j, num in enumerate(this):
                a2[num] = this[(key+1+j)%l]+1