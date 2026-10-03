S = reversed(list(input()))
plus = 0
a = []
for s in S:
    if s=="+":
        plus += 1
    elif s=="-":
        plus -= 1
    else:
        a.append(plus)
a.sort()
print(sum(a[int(len(a)/2):]) - sum(a[:int(len(a)/2)]))
