R, B = map(int, input().split())
X, Y = map(int, input().split())
 
lb = 0
rb = max(R, B)
 
m = (lb + rb) // 2
 
while lb +1 < rb:
    m = (lb + rb) // 2
    # print(lb, m, rb, R >= m, B >= m, (R - m) // (X - 1) + (B - m) // (Y - 1) >= m)
    if R >= m and B >= m and (R - m) // (X - 1) + (B - m) // (Y - 1) >= m:
        lb = m
    else:
        rb = m
print(lb)