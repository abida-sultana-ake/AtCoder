sum = 0
for i in range(3):
    a,b = map(int,input().split())
    sum += a*(b*0.1)

print(int(sum))