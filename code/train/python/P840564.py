H,W = map(int,input().split())
s = [ input() for i in range(H) ]
dx = [-1,0,1]
dy = [-1,0,1]
ans = [""]
for i in range(H):
    ans.append("")
    for j in range(W):
        flg = True
        for k in range(3):
            for l in range(3):
                nx = j + dx[k]
                ny = i + dy[l]
                if ny>=0 and nx>=0 and ny < H and nx < W:
                    if s[ny][nx] == '.':
                        flg = False

        if flg:
            ans[i] += '#'
        else:
            ans[i] += '.'

conf = [""]
for i in range(H):
    conf.append("")
    for j in range(W):
        flg = False
        for k in range(3):
            for l in range(3):
                nx = j + dx[k]
                ny = i + dy[l]
                if ny>=0 and nx>=0 and ny < H and nx < W:
                    if ans[ny][nx] == '#':
                        flg = True
        if flg:
            conf[i] += '#'
        else:
            conf[i] += '.'

isPossible = True
for i in range(H):
    for j in range(W):
        if conf[i][j] != s[i][j]:
            isPossible = False
            break

if isPossible:
    print( "possible" )
    for i in range(H):
        print (ans[i])
else:
    print("impossible")

