n = int(input())
s = list()
for i in range(n):
    s.append(input())

ans = ""
for c in "abcdefghijklmnopqrstuvwxyz":
    c_min = list()
    for ss in s:
        cnt = 0
        for cc in ss:
            if cc == c:
                cnt += 1
        c_min.append(cnt)
    ans += c*min(c_min)
    
print(ans)