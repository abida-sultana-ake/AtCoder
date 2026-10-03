import re

string = str(input())
ans = re.sub(r'[aiueo]', "", string)

print(ans)