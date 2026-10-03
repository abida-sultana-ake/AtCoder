# -*- coding: utf-8 -*-
import math
a = int(input())
if a%10==9 or math.floor(a/10)==9:
    print ("Yes")
else:
    print ("No")
