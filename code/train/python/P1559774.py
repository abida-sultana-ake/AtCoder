#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import array
from bisect import *
from collections import *
import fractions
import heapq 
from itertools import *
import math
import re
import string

N = int(input())
Ps = list(map(int, input().split()))

ans = 0
if Ps[-1] == N:
    Ps[-1], Ps[-2] = Ps[-2], Ps[-1]
    ans += 1

for i in range(N-1):
    if Ps[i] == i + 1:
        Ps[i], Ps[i+1] = Ps[i+1], Ps[i]
        ans += 1
print(ans)
