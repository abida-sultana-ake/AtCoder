from itertools import*
s = list(input())
ss = s[:]
ans = eval("".join(s))
for i in range(len(s)-1):
    for j in combinations(range(len(s)-1),i+1): #reverse をいれないとインデックスの位置が変わる
        #後ろから　insert　しないと位置が変わる
        for k in reversed(j):
            ss.insert(k+1,"+")
        ans += eval("".join(ss))
        ss = s[:]
print(ans)