N = int(input())
a = sorted([int(input()) for i in range(N)], reverse=1)
s = sum(a)
while a:
    if s%10 != 0:
        print(s)
        break
    while a:
        n = a.pop()
        if n%10 != 0:
            s-=n
            break
if len(a) == 0:
    print(0)