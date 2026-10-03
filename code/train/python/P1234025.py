#! coding UTF-8
data = input().split()
for i in range(len(data)):
    data[i] = data[i].upper()
print(data[0][0]+data[1][0]+data[2][0])
