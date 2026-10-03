
H = [0,0]
W = [0,0]
(H[0],W[0]) = map(int,input().split())
(H[1],W[1]) = map(int,input().split())

canFit = False

if H[0]==H[1] or W[0]==H[1]:
    canFit = True
if H[0]==W[1] or W[0]==W[1]:
    canFit = True

if canFit:
    print ("YES")
else:
    print ("NO")
