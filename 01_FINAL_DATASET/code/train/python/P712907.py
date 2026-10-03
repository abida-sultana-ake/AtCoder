s = input()
i = 0
while not (ord('0') <= ord(s[i]) <= ord('9')):
    i += 1
j = i
while j < len(s) and ord('0') <= ord(s[j]) <= ord('9'):
    j += 1
print(int(s[i:j]))
