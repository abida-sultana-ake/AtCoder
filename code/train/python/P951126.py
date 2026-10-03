#D
from collections import Counter
s = input()
flag = True
for i in range(len(s)-1):
    if s[i] == s[i+1]:
        print(i+1, i+2)
        flag = False
        break
    elif i <= len(s)-3 and s[i] == s[i+2]:
        print(i+1, i+3)
        flag = False
        break
if flag:
    print("-1 -1")