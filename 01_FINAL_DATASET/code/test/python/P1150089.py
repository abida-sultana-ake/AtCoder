st = str(input())
W =""

for i in st:
    if i in 'a''i''u''e''o':
        continue
    W += i

print(W)