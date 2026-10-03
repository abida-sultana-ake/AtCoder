S = input()

alp = list(map(lambda x: chr(x), range(ord('a'), ord('z')+1)))
def solve():
    for c in alp:
        cand = S.find(c*2)
        if cand != -1:
            return (cand, cand+1)
        for i in alp:
            cand = S.find(c+i+c)
            if cand != -1:
                return (cand, cand+2)

res = solve()
if res is None:
    print('-1 -1')
else:
    print(res[0]+1, res[1]+1)