cheatsheat = [0]+[(l.append(l[-1]*8+10**(i-1)*2), l[-1])[1] for l in [[0]] for i in range(1, 19)]
A, B = map(int, input().split())

def calc(n):
    s = 0
    n = str(n)
    for i in range(1, len(n)+1):
        _n, m = int(n[-i]), cheatsheat[i-1]
        if "4" in n[:-i] or "9" in n[:-i]:
            s += _n*10**(i-1)
        else:
            if _n == 4 or _n == 9:
                s += 1
            if _n > 4:
                s += m * (_n-1) + 10**(i-1)
            else:
                s += m * _n
    return s

print(calc(B)-calc(A-1))