W = input()

ans = ""
for w in W:
    if w != "a" and w != "i" and w != "u" and w != "e" and w != "o":
        ans = ans + w
        
print(ans)