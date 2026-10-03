b, c, d = map(int, input().split())

if b + c == d :
    if b - c == d :
      print('?')
    else :
      print('+')
else :
    if b - c == d :
        print('-')
    else :
        print('!')