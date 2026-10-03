a = raw_input().strip()
al = 'abcdefghijklmnopqrstuvwxyz'
for x in al:
	try:
		i = a.index(x)
	except :
		print(x)
		exit()
print('None')