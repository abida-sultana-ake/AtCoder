a = input()
b = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
     "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"]
i = 0
while len(a) > i:
    if a[i] in b:
        b.remove(a[i])
    else:
        pass
    i += 1
if not b:
    print("None")
else:
    print(b[0])
