# -*- coding: utf-8 -*-

#-------
# Initialize
S = list(input())

#-------
# Do
S_uniq = list(set(S))

#-------
# Output
if len(S) == len(S_uniq):
    print("yes")
else:
    print("no")
