K,N=map(int,input().split())
vws = [ input().split() for _ in range(N)]
v = [ vw[0] for vw in vws ]
w = [ vw[1] for vw in vws ]
#print(v)
#print(w)

assign = [""] * 10
complete = False
def f(n, pv, pw):
    global assign, complete
    if len(v[n]) == pv and len(w[n]) == pw:
        n += 1
        pv = 0
        pw = 0
    elif len(v[n]) < pv or len(w[n]) < pw:
        return
    elif len(v[n]) == pv and len(w[n]) != pw:
        return
    elif len(v[n]) != pv and len(w[n]) == pw:
        return

    if n == N:
        for i in range(1, K+1):
            print(assign[i])
        complete = True
    if complete:
        return
    
    c = ord(v[n][pv]) - ord('0')
    word = assign[c]
    if word != "":
        if word == w[n][pw:pw+len(word)]:
            f(n, pv + 1, pw + len(word))
        else:
            return
    else:
        for l in [1, 2, 3]:
            if pw + l > len(w[n]):
                continue
            word = w[n][pw:pw+l]
            assign[c] = word
            f(n, pv + 1, pw + len(word))
            assign[c] = ''

f(0, 0, 0)
