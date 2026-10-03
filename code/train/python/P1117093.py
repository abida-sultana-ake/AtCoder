n = int(input())
s = input()

sw = [1,0]
ss = [1,1]
ws = [0,1]
ww = [0,0]

def nxt(tf, last):
    if tf=='x' and last=='S':
        return ''

for idx,c in enumerate(s):
    if idx==0:
        continue
    if c == 'x':
        sw.append(sw[-1]^sw[-2])
        ss.append(ss[-1]^ss[-2])
        ws.append(ws[-1]^ws[-2])
        ww.append(ww[-1]^ww[-2])
    else:
        sw.append(1*(not(sw[-1]^sw[-2])))
        ss.append(1*(not(ss[-1]^ss[-2])))
        ws.append(1*(not(ws[-1]^ws[-2])))
        ww.append(1*(not(ww[-1]^ww[-2])))

c=s[0]
if c == 'x':
    sw.append(sw[-1]^sw[-2])
    ss.append(ss[-1]^ss[-2])
    ws.append(ws[-1]^ws[-2])
    ww.append(ww[-1]^ww[-2])
else:
    sw.append(1*(not(sw[-1]^sw[-2])))
    ss.append(1*(not(ss[-1]^ss[-2])))
    ws.append(1*(not(ws[-1]^ws[-2])))
    ww.append(1*(not(ww[-1]^ww[-2])))


def f(seq):
    # print(seq[-1],seq[0])
    return seq[-2:]==seq[:2]

def pp(seq):
    print(''.join(map(lambda x:'S' if x else 'W', seq[:-2])))

if f(sw):
    pp(sw)
elif f(ss):
    pp(ss)
elif f(ws):
    pp(ws)
elif f(ww):
    pp(ww)
else:
    print(-1)
