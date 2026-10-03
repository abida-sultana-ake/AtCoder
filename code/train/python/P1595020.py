S = input()
flag = False
for i in range(26):
    c = chr(ord('a')+i)
    if c not in S:
        print(c)
        flag = True
        break
if flag == False:
    print('None')