N = int(input())
s = [int(input()) for i in range(N)]
b=[]
for i in s:
    if i not in b:
        b.append(i)

b.sort()
print(b[-2])

