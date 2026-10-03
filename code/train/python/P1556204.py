N = int(input())

ws = []
for i in range(N):
    w = int(input())
    mi = -1
    mw = 0
    for j in range(len(ws)):
        if w <= ws[j] and w > mw:
            mw = w
            mi = j
    if mi < 0:
        ws.append(w)
    else:
        ws[mi] = w
print(len(ws))
