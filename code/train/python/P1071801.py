import re

text = input()
obj = re.match("^(dream|dreamer|erase|eraser)+$", text)
if obj:
    print("YES")
else:
    print("NO")
