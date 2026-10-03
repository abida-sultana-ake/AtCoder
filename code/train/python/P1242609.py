import sys
pattern = ["dream", "dreamer", "erase", "eraser"]
split_pattern = ["dream", "er", "ase", "r"]
grammer = {
        "ase": ["er"],
        "r": ["ase", "er"],
        "er": ["dream"],
        "dream": [],
        }
s = input()

splited = []
while s:
    for spl in split_pattern:
        if s.startswith(spl):
            splited.insert(0, spl)
            s = s[len(spl):]
            break
    else:
        print("NO")
        sys.exit()

pred = []
for word in splited:
    if not pred:
        pred = grammer[word][:]
    else:
        if word != pred[0]:
            print("NO")
            break
        else:
            del pred[0]
else:
    print("YES")
