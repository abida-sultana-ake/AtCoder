def __main__():
    s = input()

    turn = 0
    s = rem(s)
    while s:
        turn += 1
        s = rem(s)
    if turn % 2 == 0:
        print('Second')
    else:
        print('First')

def rem(s):
    if len(s) == 2:
        return False
    for i in range(len(s) - 2):
        if s[i] != s[i + 2]:
            s = s[:(i + 1)] + s[(i + 2):]
            return s
    return False
    
__main__()