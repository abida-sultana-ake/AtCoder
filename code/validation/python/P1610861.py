N = int(input())
w = list(map(str, input().split()))
d = {
        'b':'1', 'c':'1',
        'd':'2', 'w':'2',
        't':'3', 'j':'3',
        'f':'4', 'q':'4',
        'l':'5', 'v':'5',
        's':'6', 'x':'6',
        'p':'7', 'm':'7',
        'h':'8', 'k':'8',
        'n':'9', 'g':'9',
        'z':'0', 'r':'0'
    }
ans = []
for i in range(N):
    S = ""
    for c in w[i]:
        if c.lower() in d.keys():
            S += d[c.lower()]
    if len(S) > 0:
        ans.append(S)

N = len(ans)
if N == 0:
    print()
else:
    for i in range(N-1):
        print(ans[i], end=' ')
    print(ans[N-1])