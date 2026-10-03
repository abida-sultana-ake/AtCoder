s = input()

if s[0] == s[len(s)-1]:
    if len(s) % 2 == 0:
        print("First")
    else:
        print("Second")
else:
    if len(s) % 2 != 0:
        print("First")
    else:
        print("Second")