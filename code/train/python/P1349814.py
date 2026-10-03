# -*- coding: utf-8 -*-
import sys, re

N = input()
S = input()
sentence = ''
left, right = 0, 0
for s in S:
    sentence += s
    if s == '(':
        left += 1
    else:
        right += 1
    if left - right < 0:
        sentence = '(' + sentence
        left += 1
if left - right > 0:
    sentence = sentence + ')' * (left - right)
print(sentence)
