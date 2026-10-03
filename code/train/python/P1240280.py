a = int(input())
b = int(input())
c = int(input())

m = [a,b,c]
n = [a,b,c]
n.sort(reverse=True)

for i in range(0, len(n)):
    for j in range(0, len(n)):
        if m[i] == n[j]:
            print(j + 1)