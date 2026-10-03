w=input()

if all(w.count(chr(ord('a')+i))%2==0 for i in range(26)):
    print('Yes')
else:
    print('No')