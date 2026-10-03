s = list(input())
l = s.count("L")
r = s.count("R")
u = s.count("U")
d = s.count("D")
q = s.count("?")
ans = abs(r-l) + abs(u-d)
t = int(input())
if t == 1:
    ans += abs(q)
    print(ans)
elif t == 2:
    if ans < abs(q):
        w = abs(q) - ans
        if w % 2 == 0:
            print(0)
        else:
            print(1)
    else:
        ans -= abs(q)
        print(abs(ans))
