import re
s = input()
r = re.search('\d+',s)
print( s[r.start():r.end()] )
