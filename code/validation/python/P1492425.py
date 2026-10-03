h, w = map(int, input().split(" "))
n = int(input())
a = list(map(int, input().split(" ")))

mat = [] * h

line = []
for i in range(n):
    for j in range(a[i]):
        line.append(i+1)
        if len(line) == w:
            if len(mat) % 2 == 0:
                mat.append(line)
            else:
                line.reverse()
                mat.append(line)
            line = []
                
for i in mat:
    print(' '.join(map(str, i)))

