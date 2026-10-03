s=input()
g,p=0,0
w,l=0,0
t=""
for c in s:
    if c == 'g' and p < g:
        w += 1
        p += 1
        t += 'p'
    else:
        g += 1
        t += 'g'
        if c == 'p':
            l += 1
for i in range(len(s)-1, -1, -1):
    if t[i] == 'g' and s[i] == 'p':
        if p+1 <= g-1:
            l -= 1
            p += 1
            g -= 1
print(w-l)