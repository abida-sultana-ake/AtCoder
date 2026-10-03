h,w = list(map(int,input().split()))
n = int(input())
a = list(map(int,input().split()))

ans = [[0 for i in range(w)]for j in range(h)]
x = 0
y = 0
rev = 0
for i in range(len(a)):
    while(a[i]):
        ans[y][x] = str(i+1)
        a[i] -= 1
        if rev == 1:
            if x - 1 < 0:
                rev = 0
                y += 1
            else:
                x -= 1
        else:
            if x + 1 == w:
                y += 1
                rev = 1
            else:
                x += 1
for i in range(h):
    print(' '.join(ans[i]))
