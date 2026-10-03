# Minesweeper
h,w = list(map(int, input().split()))
s = []
for i in range(h):
    s.append(input())
    
ss = [[0]*(w +2) for i in range(h+2)]
#print(ss)

for i in range(h):
    for j in range(w):
        if s[i][j]=="#":
            ss[i+1][j+1]+=9
            ss[i][j]+=1
            ss[i][j+1]+=1
            ss[i][j+2]+=1
            ss[i+1][j]+=1
            ss[i+1][j+2]+=1
            ss[i+2][j]+=1
            ss[i+2][j+1]+=1
            ss[i+2][j+2]+=1

for i in range(h):
    l = ss[i+1][1:w+1]
    #print(l)
    l = [str(l[i]) if l[i]<9 else "#" for i in range(w)]
    print("".join(l))