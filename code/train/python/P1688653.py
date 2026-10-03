s = list(reversed(input()))
a = []
tmp = 0
for i in s:
    if i == "+":
        tmp += 1
    elif i == "-":
        tmp -= 1
    else:
        a.append(tmp)
a.sort()
print(sum(a[len(a)//2:])-sum(a[:len(a)//2]))
