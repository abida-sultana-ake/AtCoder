S = input()
T = input()
A = ["a", "t", "c", "o", "d", "e", "r"]
jurge = "win"
for s, t in zip(S, T):
    if s != t:
        if s == "@":
            if t not in A:
                jurge = "lose"
        elif t == "@":
            if s not in A:
                jurge = "lose"
        else:
            jurge = "lose"
if jurge == "win":
    print("You can win")
else:
    print("You will lose")