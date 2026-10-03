s = input()
d = [0,0,0,0,0,0]
for i in range(len((s))):
    if(s[i] == "A"): d[0] += 1
    if (s[i] == "B"): d[1] += 1
    if (s[i] == "C"): d[2] += 1
    if (s[i] == "D"): d[3] += 1
    if (s[i] == "E"): d[4] += 1
    if (s[i] == "F"): d[5] += 1

for i in range(len((d))):
    if(i != len(d)-1): print(d[i], end=' ')
    else : print(d[i])