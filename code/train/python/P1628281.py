import re
print('NO' if re.search('I.*C.*T', input().upper()) is None else 'YES')