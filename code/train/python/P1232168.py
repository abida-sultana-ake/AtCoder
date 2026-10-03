O = list(input())
E = list(input())
s = ''
while O or E:
    if len(E) >= len(O):
        s = E.pop() + s
    else:
        s = O.pop() + s
print(s)
