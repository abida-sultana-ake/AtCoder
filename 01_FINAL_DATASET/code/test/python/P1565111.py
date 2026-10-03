asci = [w for w in "aiueo"]
W = input()
for w in W:
    if w not in asci:
        print(w, end="")
print()
