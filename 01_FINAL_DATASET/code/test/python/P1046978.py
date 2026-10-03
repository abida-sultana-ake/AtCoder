# -*- coding: utf-8 -*-
s = input()

vowel_list = ['a','i','u','e','o']
output_string = ['vowel','consonant']

flag = False
for vowel in vowel_list:
    if vowel == s:
        flag = True

print(output_string[0] if flag == True else output_string[1])