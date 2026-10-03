src = []
for i in range(3):
    src.append((int(input()),i))
src.sort()
src.reverse()
ret = [0,0,0]
for i in range(3):
    who = src[i][1]
    ret[who] = i+1
for r in ret:
    print(r)
