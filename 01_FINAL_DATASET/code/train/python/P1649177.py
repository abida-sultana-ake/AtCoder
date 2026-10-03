txa, tya, txb, tyb, t, v = map(int,input().split())
n = int(input())
mov = t*v
for _ in range(n):
    x,y = map(int,input().split())
    if ((txa-x)**2+(tya-y)**2)**0.5 + ((txb-x)**2+(tyb-y)**2)**0.5 <= mov:
        print("YES")
        break
else:
    print("NO")
