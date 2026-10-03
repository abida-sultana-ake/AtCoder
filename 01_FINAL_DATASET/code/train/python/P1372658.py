s = input()
t = input()

if s == t:
    print("You can win")
else:
    for i in range(len(s)):
        if s[i] == t[i]:
            continue
        else:
            if s[i] == '@' and t[i] in "atcoder":
                continue
            elif t[i] == '@' and s[i] in "atcoder":
                continue
            else:
                print("You will lose")
                break
    else:
        print("You can win")