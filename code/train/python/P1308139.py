import math
Y, X, K = map(int, input().split())
a = [[0 if c=="x" else 1 for c in input()]for i in range(Y)]
#a = [[1]*500 for i in range(500)]

for x in range(X):
    fr = 0
    for y in range(Y + 1):
        if y == Y or a[y][x] == 0:
            for i in range(math.ceil((y - fr) / 2)):
                a[fr+i][x] = i+1
                a[y-i-1][x] = i+1
            fr = y + 1

count = 0
_cnt = 0
LEN = (K-1)*2 + 1
for y in range(K-1, Y-K+1):
    fr = 0
    cnt = a[y].count(0)
    for i in range(cnt+1):
        to = a[y].index(0, fr) if i < cnt else X-1
        l = to - fr + 1
        #print("y:%d // fr,to:%d,%d, l=%d"%(y,fr,to,l))
        if l < LEN:
            fr = to+1
            continue
        ok = 0
        for j in range(l-LEN+1):
            #print("start")
            ok = max(0, ok-1)
            _fr, _to = fr+j, fr+LEN-1+j
            flag = True
            flag2 = True
            #print("y=%d, ok=%d,LEN=%d"%(y, ok,LEN))
            for k in range(ok, LEN):
                #_cnt+=1
                c = k+1 if k < K else 2*K-k-1
                now = a[y][_fr+k]
                #print("x:%d,c:%d,now=%d,k=%d"%(_fr+k,c,now,k))
                if now < c:
                    flag = False
                    break
                elif k <= K-1 or flag2 and now >= K:
                    #print("o")
                    ok = k
                else:
                    #print("x")
                    flag2 = False
            if flag:
                #print("ok")
                count += 1
            else:
                ok = 0
                #print("ng")
            #print("ok=%d"%ok)
            #print(_cnt)
        fr = to+1
#print(_cnt)
#for _a in a:
#    print(_a)
print(count)