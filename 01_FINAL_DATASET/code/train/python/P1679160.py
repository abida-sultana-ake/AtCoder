n,d,k = map(int,input().split())
restr = [list(map(int,input().split())) for _ in range(d)]
for _ in range(k):
    s,t = map(int,input().split())
    for i in range(len(restr)):
        move = restr[i]
        if not s in range(move[0],move[1]+1): continue
        if t in range(move[0],move[1]+1):
            print(i+1)
            break
        if s < t:
            s = move[1]
        else:
            s = move[0]
