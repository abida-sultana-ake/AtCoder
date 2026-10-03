from collections import Counter
S = input()

counter = dict(Counter(S))
counter = sorted(counter) 
alphabets = "abcdefghijklmnopqrstuvwxyz"

found = False
for letter in alphabets:
    if letter in counter:
        continue
    else:
        found = True
        print(letter)
        break

if found is not True:
    print("None")
