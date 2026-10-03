# -*- coding: utf-8 -*-
def check_word(word):
    return word[:int(len(word)/2)] == word[int(len(word)/2):len(word)]

a = input()
count = 0
for i in range(1, len(a)):
    b = a[:-i]
    if check_word(b):
        count = len(b)
        break
print(count)