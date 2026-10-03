n = int(input())
s = []
for i in range(n):
    s.append(int(input()))

s.sort()
ans = sum(s)
if ans % 10 != 0:
    print(ans)
else:
    for i in range(n):
        if s[i] % 10 != 0:
            print(ans - s[i])
            break
    else:
        print(0)