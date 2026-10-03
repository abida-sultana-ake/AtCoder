s = input()
F = "First"
S = "Second"
if s[0] == s[-1:]:#odd
    if len(s)&1:
        print(S)
    else:
        print(F)
else:             #even
    if len(s)&1:
        print(F)
    else:
        print(S)
