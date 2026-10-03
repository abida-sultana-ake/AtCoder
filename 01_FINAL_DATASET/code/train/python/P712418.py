s = input()
n = filter(lambda x: x in map(str,range(10)),s)
print(''.join(n))