S = input()
S = S.upper()

i = S.find("I")
S = S[i:]

c = S.find("C")
S = S = S[c:]

t = S.find("T")
if i != -1 and c != -1 and t != -1:
    print("YES")
else:
    print("NO")
