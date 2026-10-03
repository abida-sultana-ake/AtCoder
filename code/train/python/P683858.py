R,B = map(int, input().split())
X,Y = map(int, input().split())
def ok(med):
    if (med > R or med > B):
        return False
    rest_R = R - med
    rest_B = B - med
    red_b = rest_R // (X - 1)
    blu_b = rest_B // (Y - 1)
    if (red_b + blu_b >= med):
        return True
    else:
        return False
left = 0
right = 1 << 60
while (right - left > 1):

    med = (right + left) // 2
    if (ok(med)):
        left = med
    else:
        right = med

print (left)
    
