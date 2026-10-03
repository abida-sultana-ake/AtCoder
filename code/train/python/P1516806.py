# coding: utf-8
import sys
contents = ''.join(sys.stdin)
r = contents.count('R')
b = contents.count('B')
print('DRAW' if r==b else 'TAKAHASHI' if r>b else 'AOKI')