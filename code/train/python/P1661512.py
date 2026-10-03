s = input()
runlength = 1
ch = s[0]
for i in range(1,len(s)):
    if s[i] == ch:
        runlength += 1
    else:
        print(ch,end="")
        print(runlength,end="")
        runlength=1
        ch = s[i]
print(ch,end="")
print(runlength)
