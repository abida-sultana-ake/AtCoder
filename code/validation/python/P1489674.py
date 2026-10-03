rc = input()
H, W = rc.split()
N = input()
colors = input()
cs = colors.split()

dim1_len = [1 for i in range(int(H)*int(W))]

count = 0
output = [[1 for i in range(int(W))] for j in range(int(H))]

for i in range(int(N)):
    n = int(cs[i])
    for j in range(n):
        dim1_len[count] = i+1
        count += 1

for i in range(int(H)):
    for j in range(int(W)):
        if i % 2 == 0:
            output[i][j] = dim1_len[i*int(W)+j]
        else:
            output[i][int(W)-j-1] = dim1_len[i*int(W)+j]
        
for i in range(len(output)):
    for j in range(len(output[0])):
        print(output[i][j],end=" ")
    print("\n")
