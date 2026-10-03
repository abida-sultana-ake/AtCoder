l = input()
g = list(filter(lambda s: s == "g", l))
p = list(filter(lambda s: s == "p", l))

print(int((len(g) - len(p)) / 2))
