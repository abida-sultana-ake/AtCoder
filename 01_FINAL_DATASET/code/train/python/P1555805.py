S = input()

for i in range(ord('a'), ord('z') + 1):
    if chr(i) not in S:
        print(chr(i))
        break
else:
    print('None')
