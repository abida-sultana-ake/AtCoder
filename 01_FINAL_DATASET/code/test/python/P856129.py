w = input()

abc = "abcdefghijklmnopqrstuvwxyz"

abc_count = []
abc_index = 0
isBeautiful = True
for ch in abc:
    abc_count.append(w.count(ch))
    if abc_count[abc_index] % 2 == 1:
        isBeautiful = False
        break
    abc_index += 1

if isBeautiful:
    print("Yes")
else:
    print("No")
