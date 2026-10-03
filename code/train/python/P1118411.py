N = int(input())
s = input()

def test(bm, b0):
    b = [True] * N
    b[-1] = bm
    b[0] = b0
    for i in range(N - 2):
        b[i + 1] = b[i - 1]
        if b[i] ^ (s[i] == 'o'):
            b[i + 1] = not b[i + 1]
    
    if b[-2] == ((s[-2] == 'o') == (b[-3] == b[-1])) and b[-1] == ((s[-1] == 'o') == (b[-2] == b[0])):
        printB(b)
        return True
    else:
        return False

def printB(b):
    for i in range(N):
        print('S' if b[i] else 'W', end='')
        
    print()
    

def main():
    if test(True, True):
        return
    elif test(True, False):
        return
    elif test(False, True):
        return
    elif test(False, False):
        return

    print(-1)

if __name__ == '__main__':
    main()