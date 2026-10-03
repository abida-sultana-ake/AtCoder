S = input()
dic = {'O':0, 'D':0, 'I':1, 'Z':2, 'S':5, 'B':8}
ret = ''
for c in S:
    if c in dic:
        ret += str(dic[c])
    else:
        ret += c
print(ret)
