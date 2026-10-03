s = raw_input()
left = min([i for i in range(len(s)) if s[i] == 'A'])
right = max([i for i in range(len(s)) if s[i] == 'Z'])
print (right - left + 1)