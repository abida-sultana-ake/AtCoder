import sys

#入力
s = str(input())
#判定
if s.isalpha() and s.islower() and len(s) <= 100 and len(s) > 0:
    i = int(input())
    if i<1 or i>len(s):
        sys.exit()
    else:
        print(s[i-1])
else:
    sys.exit()