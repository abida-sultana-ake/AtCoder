import collections
import sys
c = collections.Counter(input()).most_common()
for i in c:
	if i[1] % 2 != 0:
		print('No')
		sys.exit()

print('Yes')
