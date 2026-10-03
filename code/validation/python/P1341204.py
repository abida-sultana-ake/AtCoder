inputs = list(map(int, input().split(" ")))
R = inputs[0]
G = inputs[1]
B = inputs[2]

sum = R*100 + G*10 + B

if sum%4 == 0:
    print("YES")
else:
    print("NO")
