W=list(input())
S=""
for w in W:
    if not(w in ["a", "e", "i", "o", "u"]):
        S+=w
print(S)