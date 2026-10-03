import re

S = input()
x = r"^(dream|dreamer|erase|eraser)*$"

if re.match(x,S):
	print('YES')
else:
	print('NO')