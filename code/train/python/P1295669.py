# -*- coding: utf-8 -*-

def main():
    x,y = [int(s) for s in input().split()]
    # groups
    g1 = [1,3,5,7,8,10,12]
    g2 = [4,6,9,11]
    g3 = [2]

    res = False
    for g in (g1,g2,g3):
        # if in the same group
        if x in g and y in g:
            res = True

    if res: print('Yes')
    else: print('No')

if __name__ == '__main__':
    main()
