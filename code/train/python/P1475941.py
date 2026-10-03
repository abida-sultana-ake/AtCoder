s = input();

words = ["dream", "dreamer", "erase", "eraser"]

while(len(s) > 4):
    if s[-5:] == words[0]:
        s = s[:-5]
    elif s[-7:] == words[1]:
        s = s[:-7]
    elif s[-5:] == words[2]:
        s = s[:-5]
    elif s[-6:] == words[3]:
        s = s[:-6]
    else:
        break

print("YES") if len(s) == 0 else print("NO")