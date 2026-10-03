# -*- coding: utf-8 -*-

A, B = map(int, raw_input().split())


A += 11
B += 11
if(A%13>B%13): 
    print('Alice')
elif(A%13<B%13):
    print('Bob')
else:
    print('Draw')
    
