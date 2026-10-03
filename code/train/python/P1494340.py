s = input()
print(' '.join(map(lambda x: str(s.count(x)), [chr(i) for i in range(ord('A'), ord('F')+1)])))
