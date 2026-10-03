import re
w = (("Left", "<"), ("Right", ">"), ("AtCoder", "A"))
S = input()
for w1, w2 in w:
    S = re.sub(w1, w2, S)
print(S)