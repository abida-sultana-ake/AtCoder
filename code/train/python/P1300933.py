h, w = map(int, raw_input().split())
if h % 3 == 0 or w % 3 == 0:
    print(0)
    exit()

def calc2(h, w):
    half = h // 2
    return [half * w, (h - half) * w]
    
def calc(h, w):
    a = h // 3
    slist = []
    slist.append([a * w] + calc2(h - a, w))
    slist.append([a * w] + calc2(w, h - a))
    slist.append([(a + 1) * w] + calc2(h - a - 1, w))
    slist.append([(a + 1) * w] + calc2(w, h - a - 1))
    candi = []
    for value in slist:
        candi.append(max(value) - min(value))
    return min(candi)

print(min(calc(h, w), calc(w, h)))

    
