S=list(str(input()))

a=list('abcdefghijklmnopqrstuvwxyz')

for i in a:
    if i not in S:
        print(i)
        exit()
else:
    print('None')