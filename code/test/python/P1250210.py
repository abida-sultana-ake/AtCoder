a, b, c = map(str, input().split())
ab, bc = (0, 0)

if a[-1] == b[0]:
    ab = 1
if b[-1] == c[0]:
    bc = 1
if ab==1 and bc==1:
    print("YES")
else:
    print("NO")