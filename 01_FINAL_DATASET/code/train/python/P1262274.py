# -*- coding: utf-8 -*-

def main():
    S = input()
    t = [S[0].upper()] + [s.lower() for s in S[1:]]
    S = ''.join(t)
    print(S)

if __name__ == '__main__':
    main()
