# coding: utf-8
# Here your code !

import sys
input_line2 = sys.stdin.readline()

flag = 0
for i in range(len(input_line2)):
    for j in range(len(input_line2)):
        if i != j:
            if input_line2[i] == input_line2[j]:
                flag = 1
                break;

if flag == 1:
    print ("no")
else :
    print("yes")