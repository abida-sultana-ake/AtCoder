def f(seq, idx):    
    for i, j in zip(range(idx, len(seq)), range(idx+1, len(seq))):
        if seq[i] >= seq[j]:
            return j
    return len(seq)

def g(seq):
    idx = 0
    ret = []
    while idx < len(seq):
        ret.append((idx, f(seq, idx),))
        idx = ret[-1][-1]
    return ret

def h(l, r):
    n = r - l + 1
    return n * (n - 1) // 2


N = int(input())
a = list(map(int, input().split()))
print(sum(h(l, r) for l, r in g(a)))
