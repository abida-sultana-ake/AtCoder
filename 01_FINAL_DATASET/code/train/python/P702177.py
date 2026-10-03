n = int(input())

lst = []

for i in range(n) :
    lst.append(input())

for i in range(n) :
    s = ""
    j = n - 1
    while (j >= 0) :
        s += lst[j][i]
        j -= 1
    print(s)
