import re
S = input()
match = re.findall(r'[0-9]+',S)
print(match[0])