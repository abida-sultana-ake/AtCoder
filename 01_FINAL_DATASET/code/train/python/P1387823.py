S = input()
T = input()

atcoder = "atcoder@"

fail = False
for s,t in zip(S,T):
    if s != t:
        if s == "@" and (t in atcoder):
            continue

        if t == "@" and (s in atcoder):
            continue

        fail=True



if fail:
    print("You will lose")
else:
    print("You can win")