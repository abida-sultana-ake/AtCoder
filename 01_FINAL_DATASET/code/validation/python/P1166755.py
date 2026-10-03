# -*- coding: utf-8 -*-

a,b = raw_input().split()

if(a=='H'):
    if(b=='H'):
        print('H')
    else:
        print('D')
elif(a=='D'):
    if(b=='H'):
        print('D')
    else:
        print('H')