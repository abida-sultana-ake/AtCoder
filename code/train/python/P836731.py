# coding: utf-8

from collections import deque


s = input().strip()
answer = deque()

for c in s:
    if c == '0':
        answer.append('0')
    elif c == '1':
        answer.append('1')
    elif c == 'B':
        try:
            answer.pop()
        except IndexError:
            answer = deque()

for c in answer:
    print(c, end='')
print('')