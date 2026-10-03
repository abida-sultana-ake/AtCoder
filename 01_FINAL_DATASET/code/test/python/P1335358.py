(l, h) = (int(i) for i in input().split())
n = int(input())

a = []
for i in range(n):
    a.append(int(input()))
    
for i in a:
    if l <= i and i <= h:
        print(0)
    elif i < l:
        print(l-i)
    else:
        print(-1)