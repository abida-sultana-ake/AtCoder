M = int(input())
x = M * M
y = (M+1)*(M+1)
while (x+99)//100 < (y+99)//100:
    x = (x+99)//100
    y = (y+99)//100
print(x)
