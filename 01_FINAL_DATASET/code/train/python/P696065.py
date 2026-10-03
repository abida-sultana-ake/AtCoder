x1, y1, r = map(int,input().split())
r2 = r ** 2
x2,y2,x3,y3=map(int,input().split())
def out_of_rect(x,y):
    global x2, y2, x3, y3
    return (x < x2 or x > x3) or (y < y2 or y > y3)

def out_of_circ(x, y):
    global x1, y1r2
    return (x - x1) ** 2 + (y - y1) ** 2 > r2

def output(flg):
    if flg:
        print("YES")
    else:
        print("NO")

output(out_of_rect(x1 + r, y1) or out_of_rect(x1 - r, y1) or out_of_rect(x1, y1 + r) or out_of_rect(x1, y1 - r))
output(out_of_circ(x2,y2) or out_of_circ(x3,y2) or out_of_circ(x2,y3) or out_of_circ(x3,y3))
